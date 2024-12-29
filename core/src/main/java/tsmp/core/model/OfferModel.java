package tsmp.core.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import tsmp.core.dto.Offer;
import tsmp.core.service.OffersHolderService;
import tsmp.core.utils.Const;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OfferModel {
    @Inject
    private OffersHolderService offersHolderService;

    @Optional
    @ValueMapValue
    private String productTeaser;

    @Optional
    @ValueMapValue
    private String offerType;

    @Optional
    @ValueMapValue
    private String offerId;

    @Optional
    @ValueMapValue
    private String fileReference;

    private Offer offer;

    @PostConstruct
    protected void init() {
        if (offerType.equals(Const.TARIFF_PLAN)) {
            offer = (Offer) offersHolderService.getTariffPlans().stream()
                    .filter(tariffPlanDto -> offerId.equals(tariffPlanDto.getId()))
                    .findFirst().orElseGet(null);
        } else {
            offer = (Offer) offersHolderService.getHardwareProducts().stream()
                    .filter(tariffPlanDto -> offerId.equals(tariffPlanDto.getId()))
                    .findFirst().orElseGet(null);

        }
    }

    public OffersHolderService getOffersHolderService() {
        return offersHolderService;
    }

    public String getProductTeaser() {
        return productTeaser;
    }

    public String getOfferType() {
        return offerType;
    }

    public String getOfferId() {
        return offerId;
    }

    public String getFileReference() {
        return fileReference;
    }

    public Offer getOffer() {
        return offer;
    }
}
