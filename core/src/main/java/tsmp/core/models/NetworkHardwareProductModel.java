package tsmp.core.models;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

public class NetworkHardwareProductModel {

    @ValueMapValue
    private String id;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private String category;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String price;

    @ValueMapValue
    private String speed;

    @ValueMapValue
    private String ports;

    @ValueMapValue
    private String networkType;

    @ValueMapValue
    private String features;

    @ValueMapValue
    private String availability;


    public NetworkHardwareProductModel(String id, String name, String category, String description, String price,
                                       String speed, String ports, String networkType, String features,
                                       String availability) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.speed = speed;
        this.ports = ports;
        this.networkType = networkType;
        this.features = features;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getSpeed() {
        return speed;
    }

    public String getPorts() {
        return ports;
    }

    public String getNetworkType() {
        return networkType;
    }

    public String getFeatures() {
        return features;
    }

    public String getAvailability() {
        return availability;
    }
}
