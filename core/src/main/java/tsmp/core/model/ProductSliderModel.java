package tsmp.core.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import tsmp.core.dto.NetworkHardwareDto;
import tsmp.core.utils.Const;
import tsmp.core.utils.JsonDataTransformer;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductSliderModel {

    @Optional
    @ResourcePath(path = Const.HARDWARE_PRODUCT_DATASOURCE_PATH)
    private Resource hardwareProductsDatasource;

    @Optional
    @ValueMapValue
    private String sliderText;

    @Optional
    @ValueMapValue
    private List<String> productIds;

    private List<NetworkHardwareDto> productItems;

    @PostConstruct
    protected void init() {
        String jsonData = hardwareProductsDatasource.getValueMap().get(Const.JSON_DATA_PROPERTY, String.class);

        List<NetworkHardwareDto> networkHardwares = JsonDataTransformer.json2Collection(jsonData, NetworkHardwareDto.class);

        productItems = networkHardwares.stream()
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
