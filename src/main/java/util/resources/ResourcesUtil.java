package util.resources;

import java.io.File;
import java.net.URL;

/**
 * Created by liangjj on 2017/9/15.
 */
public class ResourcesUtil {
    private ResourcesUtil() {
    }

    /**
     * 根据文件名称获取文件路径
     *
     * @param fileName 文件名称
     * @return
     */
    public static String getFilePath(String fileName) {
        URL url = ResourcesUtil.class.getClassLoader().getResource(fileName);
        File file = null;
        if (url != null) {
            file = new File(url.getFile());
        }
        return file != null ? file.getPath() : null;
    }
}
