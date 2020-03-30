package util.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liangjj on 2017/9/13.
 */
class Md5Util {
    private Md5Util() {
    }

    /**
     * 对字符串 MD5 加密
     *
     * @param str
     * @return
     */
//    static String getMD5(String str) throws NoSuchAlgorithmException {
//        // 创建具有指定算法名称的 MessageDigest 实例对象
//        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//        // 使用指定的字节更新摘要
//        messageDigest.update(str.getBytes());
//        // 计算消息摘要
//        byte[] magnitude = messageDigest.digest();
//        // 将 BigInteger 的符号-数量表示形式转换为 BigInteger
//        BigInteger bigInteger = new BigInteger(1, magnitude);
//        // 返回此 BigInteger 的十六进制字符串表示形式
//        return bigInteger.toString(16);
//    }
}
