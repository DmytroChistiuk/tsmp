package tsmp.core.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import tsmp.core.dto.NetworkHardwareDto;
import tsmp.core.service.OffersHolderService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductSliderModel {

    @Inject
    private OffersHolderService offersHolderService;

    @Optional
    @ValueMapValue
    private String sliderText;

    @Optional
    @ValueMapValue
    private List<String> productIds;

    private List<NetworkHardwareDto> productItems;

    @PostConstruct
    protected void init() {
        List<NetworkHardwareDto> hardwareProducts = offersHolderService.getHardwareProducts();

        productItems = hardwareProducts.stream()
                .filter(product -> productIds.contains(product.getId()))
                .collect(Collectors.toList());
    }

    public String getSliderText() {
        return sliderText;
    }

    public List<NetworkHardwareDto> getProductItems() {
        return productItems;
    }
}
