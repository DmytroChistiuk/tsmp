package tsmp.core.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import tsmp.core.dto.TariffPlanDto;
import tsmp.core.service.OffersHolderService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TariffPlanComparatorModel {

    @Inject
    private OffersHolderService offersHolderService;

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
        List<TariffPlanDto> tariffPlans = offersHolderService.getTariffPlans();

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
