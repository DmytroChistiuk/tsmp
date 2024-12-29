package tsmp.core.servlets;

import com.adobe.cq.commerce.common.ValueMapDecorator;
import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.crx.JcrConstants;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import tsmp.core.dto.TariffPlanDto;
import tsmp.core.service.OffersHolderService;

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

    private static final String VALUE = "value";
    private static final String TEXT = "text";

    @Reference
    private OffersHolderService offersHolderService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        ResourceResolver resourceResolver = request.getResourceResolver();
        List<TariffPlanDto> tariffPlanDtos = offersHolderService.getTariffPlans();

        DataSource ds =
                new SimpleDataSource(
                        new TransformIterator(
                                tariffPlanDtos.iterator(),
                                input -> {
                                    TariffPlanDto model = (TariffPlanDto) input;
                                    ValueMap vm = new ValueMapDecorator(new HashMap<>());
                                    vm.put(VALUE, model.getId());
                                    vm.put(TEXT, model.getName());
                                    return new ValueMapResource(
                                            resourceResolver, new ResourceMetadata(),
                                            JcrConstants.NT_UNSTRUCTURED, vm);
                                }));
        request.setAttribute(DataSource.class.getName(), ds);
    }

}

