package util.common;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @Author: Junjia
 * @Date: 2020/10/30 17:37
 */
public class RegExpValidatorUtilTest extends TestCase {
    public void testIsUrl() {
        String url = "https://cn.bing.com/";
        boolean result = RegExpValidatorUtil.isUrl(url);
        Assert.assertTrue(result);
    }
}