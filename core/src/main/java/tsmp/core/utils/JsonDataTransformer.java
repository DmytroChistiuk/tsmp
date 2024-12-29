package tsmp.core.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonDataTransformer {
    private JsonDataTransformer() {

    }

    public static <T> List<T> json2Collection(String json, Class<T> type) {
        return new Gson().fromJson(json, TypeToken.getParameterized(List.class, type).getType());
    }

    public static String collection2Json(List<?> collection) {
        return new Gson().toJson(collection);
    }
}
