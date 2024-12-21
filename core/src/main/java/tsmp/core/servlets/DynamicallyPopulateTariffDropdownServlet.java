package tsmp.core.servlets;

import com.adobe.cq.commerce.common.ValueMapDecorator;
import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.crx.JcrConstants;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tsmp.core.dto.TariffPlanDto;
import tsmp.core.utils.Const;
import tsmp.core.utils.JsonDataTransformer;

import javax.servlet.Servlet;
import java.util.HashMap;
import java.util.List;

@Component(
        service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "= Dynamically Populate Tariff Dropdown Servlet",
                "sling.servlet.resourceTypes=" + "/apps/tariffDropDown"
        })
public class DynamicallyPopulateTariffDropdownServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicallyPopulateTariffDropdownServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource tariffResource = resourceResolver.getResource(Const.TARIFF_PLAN_DATASOURCE_PATH);
        String jsonData = tariffResource.getValueMap().get(Const.JSON_DATA_PROPERTY, String.class);
        List<TariffPlanDto> tariffPlanDtos = JsonDataTransformer.json2Collection(jsonData, TariffPlanDto.class);
        DataSource ds =
                new SimpleDataSource(
                        new TransformIterator(
                                tariffPlanDtos.iterator(),
                                input -> {
                                    TariffPlanDto model = (TariffPlanDto) input;
                                    ValueMap vm = new ValueMapDecorator(new HashMap<>());
                                    vm.put("value", model.getId());
                                    vm.put("text", model.getName());
                                    return new ValueMapResource(
                                            resourceResolver, new ResourceMetadata(),
                                            JcrConstants.NT_UNSTRUCTURED, vm);
                                }));
        request.setAttribute(DataSource.class.getName(), ds);
    }

}

