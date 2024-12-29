package tsmp.core.dto;

import com.poiji.annotation.ExcelCellName;

public class TariffPlanDto extends Offer{

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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getAvailability() {
        return availability;
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
}
