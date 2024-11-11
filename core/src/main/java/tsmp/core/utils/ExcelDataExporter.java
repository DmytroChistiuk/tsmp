package tsmp.core.utils;

import com.poiji.bind.Poiji;

import java.io.File;
import java.util.List;

public class ExcelDataExporter {
    public static <T> List<T> exportExcelData(String fileLocation, Class<T> type) {
        return Poiji.fromExcel(new File(fileLocation), type);
    }
}
