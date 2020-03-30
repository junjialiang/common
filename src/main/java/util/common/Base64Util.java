package util.common;

import util.helper.Charset;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by liangjj on 2017/9/14.
 */
class Base64Util {
    private Base64Util() {
    }

    /**
     * 编码
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
//    static String encode(String str) throws UnsupportedEncodingException {
//        return Base64.getEncoder().encodeToString(str.getBytes(Charset.UTF8.toString()));
//    }

    /**
     * 解码
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
//    static String decode(String str) throws UnsupportedEncodingException {
//        byte[] bytes = Base64.getDecoder().decode(str);
//        return new String(bytes, Charset.UTF8.toString());
//    }
}
