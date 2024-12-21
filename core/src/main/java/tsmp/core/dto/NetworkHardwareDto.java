package tsmp.core.dto;

import com.poiji.annotation.ExcelCellName;

public class NetworkHardwareDto {

    @ExcelCellName("Product ID")
    private String id;

    @ExcelCellName("Product Name")
    private String name;

    @ExcelCellName("Category")
    private String category;

    @ExcelCellName("Description")
    private String description;

    @ExcelCellName("Price")
    private String price;

    @ExcelCellName("Speed/Capacity")
    private String speed;

    @ExcelCellName("Ports")
    private String ports;

    @ExcelCellName("Network Type")
    private String networkType;

    @ExcelCellName("Features")
    private String features;

    @ExcelCellName("Availability")
    private String availability;

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
