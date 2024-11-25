package tsmp.core.utils;

import tsmp.core.models.NetworkHardwareProductModel;
import tsmp.core.models.TariffPlanModel;

import java.util.Arrays;

public enum AssetTypeToModel {
    NETWORK_HARDWARE("xml-asset-type:hardware-product", NetworkHardwareProductModel.class),
    TARIFF_PLAN("xml-asset-type:tariff-plan", TariffPlanModel.class);

    private final String assetTypeTag;
    private final Class<?> modelClass;

    AssetTypeToModel(String assetTypeTag, Class<?> modelClass) {
        this.assetTypeTag = assetTypeTag;
        this.modelClass = modelClass;
    }

    public String getAssetTypeTag() {
        return assetTypeTag;
    }

    public Class<?> getModelClass() {
        return modelClass;
    }

    public Class<?> getModelClassByAssetTag(String assetTypeTag) throws Exception {
        return Arrays.stream(AssetTypeToModel.values())
                .filter(assetType -> assetTypeTag.equals(assetType.getAssetTypeTag()))
                .map(AssetTypeToModel::getModelClass)
                .findAny().orElseThrow(Exception::new);
    }
}
