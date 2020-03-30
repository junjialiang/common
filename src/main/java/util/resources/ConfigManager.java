package util.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by liangjj on 2017/9/25.
 */
class ConfigManager {
    private ConfigManager() {
    }

    /**
     * 读取.properties配置文件
     *
     * @param filename
     * @param key
     * @return
     */
//    static String getValueByKey(String filename, String key) {
//        Properties properties = new Properties();
//        try (InputStream inputStream = ConfigManager.class.getResourceAsStream("/" + filename)) {
//            if (inputStream != null) {
//                properties.load(inputStream);
//                return properties.getProperty(key);
//            }
//        } catch (IOException e) {
//            Log4j.error("ConfigManager.getValueByKey", e);
//        } finally {
//            properties.clear();
//        }
//        return null;
//    }
}
