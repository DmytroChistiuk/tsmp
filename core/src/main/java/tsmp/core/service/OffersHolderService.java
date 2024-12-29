package tsmp.core.service;

import tsmp.core.dto.NetworkHardwareDto;
import tsmp.core.dto.TariffPlanDto;

import java.util.List;

public interface OffersHolderService {
    void reinitOffer(String offerName, List<?> offers);

    List<NetworkHardwareDto> getHardwareProducts();

    List<TariffPlanDto> getTariffPlans();
}
