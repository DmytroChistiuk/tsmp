package tsmp.core.models;

import com.poiji.annotation.ExcelCellName;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

public class NetworkHardwareProductModel {

    @ValueMapValue
    @ExcelCellName("Product ID")
    private String id;

    @ValueMapValue
    @ExcelCellName("Product Name")
    private String name;

    @ValueMapValue
    @ExcelCellName("Category")
    private String category;

    @ValueMapValue
    @ExcelCellName("Description")
    private String description;

    @ValueMapValue
    @ExcelCellName("Price")
    private String price;

    @ValueMapValue
    @ExcelCellName("Speed/Capacity")
    private String speed;

    @ValueMapValue
    @ExcelCellName("Ports")
    private String ports;

    @ValueMapValue
    @ExcelCellName("Network Type")
    private String networkType;

    @ValueMapValue
    @ExcelCellName("Features")
    private String features;

    @ValueMapValue
    @ExcelCellName("Availability")
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
