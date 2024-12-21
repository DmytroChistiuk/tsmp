package tsmp.core.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import tsmp.core.dto.TariffPlanDto;
import tsmp.core.utils.Const;
import tsmp.core.utils.JsonDataTransformer;

import javax.annotation.PostConstruct;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TariffPlanComparatorModel {

    @Optional
    @ResourcePath(path = Const.TARIFF_PLAN_DATASOURCE_PATH)
    private Resource tariffPlanDatasource;

    @Optional
    @ValueMapValue
    private String firstTariffId;

    @Optional
    @ValueMapValue
    private String secondTariffId;

    private TariffPlanDto firstTariff;

    private TariffPlanDto secondTariff;

    @PostConstruct
    protected void init() {
        String jsonData = tariffPlanDatasource.getValueMap().get(Const.JSON_DATA_PROPERTY, String.class);

        List<TariffPlanDto> tariffPlans = JsonDataTransformer.json2Collection(jsonData, TariffPlanDto.class);

        firstTariff = tariffPlans.stream()
                .filter(tariffPlan -> firstTariffId.equals(tariffPlan.getId()))
                .findAny().orElse(null);

        secondTariff = tariffPlans.stream()
                .filter(tariffPlan -> secondTariffId.equals(tariffPlan.getId()))
                .findAny().orElse(null);
    }


    public TariffPlanDto getFirstTariff() {
        return firstTariff;
    }

    public TariffPlanDto getSecondTariff() {
        return secondTariff;
    }
}
