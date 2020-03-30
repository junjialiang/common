package util.common;

import java.io.*;

/**
 * Created by liangjj on 2017/9/15.
 */
class FileUtil {
    private FileUtil() {
    }

    /**
     * 判断指定路径的文件是否存在
     *
     * @param pathname
     * @return
     */
//    static boolean isExist(String pathname) {
//        if (StringUtil.isEmpty(pathname)) {
//            return false;
//        }
//        File file = new File(pathname);
//        return file.exists();
//    }

    /**
     * 获取指定路径的文件的字节数组
     *
     * @param pathname
     * @return
     */
    static byte[] getBytes(String pathname) {
        byte[] bytes = new byte[0];
        File file = new File(pathname);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            bytes = new byte[fileInputStream.available()];
            int length = fileInputStream.read(bytes);
            if (length > 0) {
                return bytes;
            }
        } catch (IOException e) {
            // Log4j.error("FileUtil.getBytes", e);
        }
        return bytes;
    }

    /**
     * 获取指定路径的文件的名称
     *
     * @param pathname
     * @return
     */
    static String getFileName(String pathname) {
        File file = new File(pathname);
        return file.getName();
    }

    /**
     * 读取文件内容
     *
     * @param pathname
     * @return
     */
//    static String readFileContent(String pathname) {
//        File file = new File(pathname);
//        StringBuilder stringBuilder = new StringBuilder();
//        try (FileReader fileReader = new FileReader(file);
//             // 构造一个 BufferedReader 类来读取文件
//             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) { // 使用 readLine 方法，一次读一行
//                stringBuilder.append(line);
//            }
//        } catch (IOException e) {
//            Log4j.error("FileUtil.readFileContent", e);
//        }
//        return stringBuilder.toString();
//    }
}
