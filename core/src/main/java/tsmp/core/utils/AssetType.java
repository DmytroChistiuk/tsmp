package tsmp.core.utils;

import tsmp.core.models.NetworkHardwareProductModel;
import tsmp.core.models.TariffPlanModel;

import java.util.Arrays;
import java.util.Optional;

public enum AssetType {
    NETWORK_HARDWARE("xml-asset-type:hardware-product", NetworkHardwareProductModel.class, "/somepath"),
    TARIFF_PLAN("xml-asset-type:tariff-plan", TariffPlanModel.class, "/somepath2");

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
