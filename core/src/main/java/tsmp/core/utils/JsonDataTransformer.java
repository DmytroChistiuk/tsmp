package tsmp.core.utils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class JsonDataTransformer {

    public static <T> List<T> json2Collection(String json, Class<T> type) {
        return Arrays.asList(new Gson().fromJson(json, type));
    }

    public static String collection2Json(List collection) {
        return new Gson().toJson(collection);
    }
}
