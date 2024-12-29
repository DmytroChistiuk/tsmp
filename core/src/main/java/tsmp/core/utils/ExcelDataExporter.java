package tsmp.core.utils;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

import java.io.InputStream;
import java.util.List;

public class ExcelDataExporter {

    private ExcelDataExporter() {

    }

    public static <T> List<T> exportExcelData(InputStream stream, Class<T> type) {
        return Poiji.fromExcel(stream, PoijiExcelType.XLSX, type);
    }
}
