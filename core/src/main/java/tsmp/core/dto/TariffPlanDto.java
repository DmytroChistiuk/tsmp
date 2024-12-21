package tsmp.core.dto;

import com.poiji.annotation.ExcelCellName;

public class TariffPlanDto {

    @ExcelCellName("Product ID")
    private String id;

    @ExcelCellName("Product Name")
    private String name;

    @ExcelCellName("Category")
    private String category;

    @ExcelCellName("Description")
    private String description;

    @ExcelCellName("Price")
    private String connectionPrice;

    @ExcelCellName("Monthly Cost")
    private String monthlyCost;

    @ExcelCellName("Contract Duration")
    private String duration;

    @ExcelCellName("Data Allowance")
    private String dataAllowance;

    @ExcelCellName("Voice Allowance")
    private String voiceAllowance;

    @ExcelCellName("Text Allowance")
    private String textAllowance;

    @ExcelCellName("Network Coverage")
    private String networkCoverage;

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

    public String getConnectionPrice() {
        return connectionPrice;
    }

    public String getMonthlyCost() {
        return monthlyCost;
    }

    public String getDuration() {
        return duration;
    }

    public String getDataAllowance() {
        return dataAllowance;
    }

    public String getVoiceAllowance() {
        return voiceAllowance;
    }

    public String getTextAllowance() {
        return textAllowance;
    }

    public String getNetworkCoverage() {
        return networkCoverage;
    }

    public String getAvailability() {
        return availability;
    }
}
