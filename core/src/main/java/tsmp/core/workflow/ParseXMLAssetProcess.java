package tsmp.core.workflow;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.commons.util.DamUtil;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tsmp.core.utils.AssetType;
import tsmp.core.utils.CQUtils;
import tsmp.core.utils.ExcelDataExporter;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component(service = WorkflowProcess.class, immediate = true, property = {
        "process.label=" + "Parse XML Asset"
})
public class ParseXMLAssetProcess implements WorkflowProcess {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParseXMLAssetProcess.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        try (ResourceResolver resourceResolver = CQUtils.getResourceResolver(workflowSession.getSession(), resourceResolverFactory)) {
            String payloadPath = workItem.getWorkflowData().getPayload().toString();
            Resource payloadResource = resourceResolver.getResource(payloadPath);

            if (Objects.isNull(payloadResource)) {
                LOGGER.error("Failed to get payload resource by {} path.", payloadPath);
                return;
            }

            Resource payloadMetadata = payloadResource.getChild("/jcr:content/metadata");

            if (Objects.isNull(payloadMetadata)) {
                LOGGER.error("Failed to get payload metadata for resource {}.", payloadPath);
                return;
            }

            String xmlTypeTag = payloadMetadata.getValueMap().get("cq:typeTag", String.class);
            Asset payloadAsset = DamUtil.resolveToAsset(payloadResource);

            if (Objects.nonNull(xmlTypeTag) && Objects.nonNull(payloadAsset)) {
                InputStream inputStream = payloadAsset.getOriginal().getStream();
                Optional<AssetType> assetTypeValueByAssetTypeTag = AssetType.getAssetTypeValueByAssetTypeTag(xmlTypeTag);

                if (assetTypeValueByAssetTypeTag.isPresent()) {
                    AssetType assetType = assetTypeValueByAssetTypeTag.get();

                    List<?> entities = ExcelDataExporter.exportExcelData(inputStream, assetType.getModelClass());
                    saveEntities(entities, assetType.getRepositoryPath(), resourceResolver);
                }
            }

        } catch (LoginException e) {
            LOGGER.error("Failed to login with current service user.");
        }
    }

    private void saveEntities(List<?> entities, String repositoryPath, ResourceResolver resourceResolver) {
        //TODO save entities
    }
}
