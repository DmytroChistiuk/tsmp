package tsmp.core.utils;

import tsmp.core.models.NetworkHardwareProductModel;
import tsmp.core.models.TariffPlanModel;

import java.util.Arrays;
import java.util.Optional;

public enum AssetType {
    NETWORK_HARDWARE(Const.HARDWARE_PRODUCT_TAG, NetworkHardwareProductModel.class, Const.HARDWARE_PRODUCT_DATASOURCE_PATH),
    TARIFF_PLAN(Const.TARIFF_PLAN_TAG, TariffPlanModel.class, Const.TARIFF_PLAN_DATASOURCE_PATH);

    private final String assetTypeTag;
    private final Class<?> modelClass;
    private final String repositoryPath;

    AssetType(String assetTypeTag, Class<?> modelClass, String repositoryPath) {
        this.assetTypeTag = assetTypeTag;
        this.modelClass = modelClass;
        this.repositoryPath = repositoryPath;
    }

    public String getAssetTypeTag() {
        return assetTypeTag;
    }

    public Class<?> getModelClass() {
        return modelClass;
    }

    public String getRepositoryPath() {
        return repositoryPath;
    }

    public static Optional<AssetType> getAssetTypeValueByAssetTypeTag(String assetTypeTag) {
        return Arrays.stream(AssetType.values())
                .filter(assetType -> assetTypeTag.equals(assetType.getAssetTypeTag()))
                .findFirst();
    }
}
