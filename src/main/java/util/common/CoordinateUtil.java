package util.common;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Junjia on 2019/12/13 18:50.
 */
class CoordinateUtil {
    private CoordinateUtil() {
    }

    private static final String KEY = "7d9fbeb43e975cd1e9477a7e5d5e192a";

    /**
     * 通过详细地址获得经纬度（示例：上海市闵行区申富路611号A栋）
     *
     * @param detailedAddress
     * @return
     */
    static Map<String, String> getLngLat(String detailedAddress) {
        BufferedReader in = null;
        try {
            detailedAddress = URLEncoder.encode(detailedAddress, "UTF-8");
            URL url = new URL("http://api.map.baidu.com/geocoder?address=" + detailedAddress
                    + "&output=json&key=" + KEY);

            in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            String res;
            StringBuilder sb = new StringBuilder();
            while ((res = in.readLine()) != null) {
                sb.append(res.trim());
            }
            String str = sb.toString();
            Map<String, String> map;
            if (StringUtils.isNotEmpty(str)) {
                int lngStart = str.indexOf("lng\":");
                int lngEnd = str.indexOf(",\"lat");
                int latEnd = str.indexOf("},\"precise");
                if (lngStart > 0 && lngEnd > 0 && latEnd > 0) {
                    String lng = str.substring(lngStart + 5, lngEnd);
                    String lat = str.substring(lngEnd + 7, latEnd);
                    map = new HashMap<>();
                    map.put("lng", lng);
                    map.put("lat", lat);
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}