package util.common;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import util.helper.Charset;
import util.helper.HttpContentType;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liangjj on 2017/9/15.
 */
class HttpUtil {
    private HttpUtil() {
    }

    /**
     * 向指定 URL 发送 GET 请求
     *
     * @param url
     * @return
     */
    static String doGet(String url) {
        // 创建 CloseableHttpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建 httpGet 请求
            HttpGet httpGet = new HttpGet(url);
            // 执行 http 请求
            response = httpClient.execute(httpGet);
            resultString = EntityUtils.toString(response.getEntity(), Charset.UTF8.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(httpClient, response);
        }
        return resultString;
    }

    /**
     * 向指定 URL 发送 POST 请求（数据格式为 JSON/XML）
     *
     * @param url
     * @param json
     * @return
     */
    static String doPostWithJSON(String url, String json) {
        // 创建 CloseableHttpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建 HttpPost 请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行 http 请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), Charset.UTF8.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(httpClient, response);
        }
        return resultString;
    }

    /**
     * 关闭流
     *
     * @param httpClient
     * @param response
     */
    private static void close(CloseableHttpClient httpClient, CloseableHttpResponse response) {
        try {
            httpClient.close();
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向指定 URL 发送 POST 请求（发送附件）
     * @param url
     * @param filePath      文件的绝对路径
     * @param contentType
     * @param name          文件扩展名
     * @return
     */
    static String doPostWithFile(String url, String filePath, HttpContentType contentType,String name) {
        byte[] bytes = FileUtil.getBytes(filePath);
        String filename = FileUtil.getFileName(filePath);

        String boundary = "------WebKitFormBoundary------";
        try {
            URL url2 = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");

            // Request Headers
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:30.0) Gecko/20100101 Firefox/30.0");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            httpURLConnection.setRequestProperty("Cache-Control", "no-cache");

            // Request Payload
            OutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            String requestPayload = "\r\n" + "--" + boundary + "\r\n" +
                    "Content-Disposition: form-data; name=\""+name+"\"; filename=\"" + filename + "\"\r\n" +
                    "Content-Type:" + contentType + "\r\n\r\n";
            outputStream.write(requestPayload.getBytes());
            if (bytes != null) {
                outputStream.write(bytes, 0, bytes.length);
            }
            byte[] endData = ("\r\n--" + boundary + "--\r\n").getBytes();
            outputStream.write(endData);
            outputStream.flush();

            // 读取返回数据
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            // Log4j.error("HttpUtil.close", e);
        }
        return "";
    }
}
