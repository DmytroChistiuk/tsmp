package tsmp.core.models;

import com.poiji.annotation.ExcelCellName;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class TariffPlanModel {

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
    private String connectionPrice;

    @ValueMapValue
    @ExcelCellName("Monthly Cost")
    private String monthlyCost;

    @ValueMapValue
    @ExcelCellName("Contract Duration")
    private String duration;

    @ValueMapValue
    @ExcelCellName("Data Allowance")
    private String dataAllowance;

    @ValueMapValue
    @ExcelCellName("Voice Allowance")
    private String voiceAllowance;

    @ValueMapValue
    @ExcelCellName("Text Allowance")
    private String textAllowance;

    @ValueMapValue
    @ExcelCellName("Network Coverage")
    private String networkCoverage;

    @ValueMapValue
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
