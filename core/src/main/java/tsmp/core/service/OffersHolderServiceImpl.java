package tsmp.core.service;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tsmp.core.dto.NetworkHardwareDto;
import tsmp.core.dto.TariffPlanDto;
import tsmp.core.utils.AssetType;
import tsmp.core.utils.CQUtils;
import tsmp.core.utils.Const;
import tsmp.core.utils.JsonDataTransformer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component(service = OffersHolderService.class)
public class OffersHolderServiceImpl implements OffersHolderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffersHolderServiceImpl.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    private List<NetworkHardwareDto> hardwareProducts;
    private List<TariffPlanDto> tariffPlans;


    @Activate
    public void activate() {
        try (ResourceResolver resourceResolver = CQUtils.getResourceResolver(resourceResolverFactory)) {
            hardwareProducts = (List<NetworkHardwareDto>) initOffer(resourceResolver, AssetType.NETWORK_HARDWARE);
            tariffPlans = (List<TariffPlanDto>) initOffer(resourceResolver, AssetType.TARIFF_PLAN);
        } catch (LoginException e) {
            LOGGER.error("Failed to get activate service");
        }
    }

    private List<?> initOffer(ResourceResolver resourceResolver, AssetType assetType) {
        String repositoryPath = assetType.getRepositoryPath();
        Resource datasourceResource = resourceResolver.getResource(repositoryPath);

        if (Objects.isNull(datasourceResource)) {
            LOGGER.error("Failed to get resource by {} path", repositoryPath);
            return Collections.emptyList();
        }


        String jsonData = (String) datasourceResource.getValueMap()
                .getOrDefault(Const.JSON_DATA_PROPERTY, "[]");
        return JsonDataTransformer.json2Collection(jsonData, assetType.getModelClass());
    }

    @Override
    public void reinitOffer(String offerName, List<?> offers) {
        switch (offerName) {
            case (Const.TARIFF_PLAN):
                tariffPlans = (List<TariffPlanDto>) offers;
                break;
            case (Const.HARDWARE_PRODUCT):
                hardwareProducts = (List<NetworkHardwareDto>) offers;
                break;
            default:
                LOGGER.error("Failed to init offer");
        }
    }

    @Override
    public List<NetworkHardwareDto> getHardwareProducts() {
        return hardwareProducts;
    }

    @Override
    public List<TariffPlanDto> getTariffPlans() {
        return tariffPlans;
    }
}
