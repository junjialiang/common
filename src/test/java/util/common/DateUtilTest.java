package util.common;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import util.helper.DatePattern;

/**
 * Created by liangjj on 2017/9/14.
 */
public class DateUtilTest {
    @Test
    public void testGetDateByPattern() {
        String ymd = DateUtil.getDateByPattern(DatePattern.YMD); // 2017-09-14
        Assert.assertFalse(StringUtils.isBlank(ymd));
        Assert.assertEquals(10, ymd.length());

        String ymdHms = DateUtil.getDateByPattern(DatePattern.YMDHMS); // 2018-04-09 09:29:12
        Assert.assertFalse(StringUtils.isBlank(ymdHms));
        Assert.assertEquals(19, ymdHms.length());

        String ymdHmsS = DateUtil.getDateByPattern(DatePattern.YMDHMSS); // 2018-04-09 09:29:12 482
        Assert.assertFalse(StringUtils.isBlank(ymdHmsS));
        Assert.assertEquals(23, ymdHmsS.length());
    }

    @Test
    public void testConvertMillisToDate() {
        String date = DateUtil.convertMillisToDate(System.currentTimeMillis());
        Assert.assertEquals(19, date.length());
    }

//    @Test
//    public void testGetMillisecondFromDays() {
//        long millisecond = DateUtil.getMillisecondFromDays(3);
//        Assert.assertTrue(millisecond >= 86400000L);
//    }
}