package util.common;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liangjj on 2017/10/18.
 */
class JsonUtil {
    private JsonUtil() {
    }

    /**
     * 将 JSON 字符串转化成对象（已废弃）
     *
     * @param jsonStr
     * @param obj
     * @return
     */
//    static <T> T convertJsonToObject(String jsonStr, Class<T> obj) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(jsonStr, obj);
//    }

    /**
     * 将 JSON 字符串对象转换成 HashMap 对象
     *
     * @param json
     * @return
     */
    static Map jsonToMap(String json) {
        Map hashMap = new HashMap<>();
        Gson gson = new Gson();
        hashMap = gson.fromJson(json, hashMap.getClass());
        return hashMap;
    }
}