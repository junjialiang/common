package util.common;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Junjia on 2019/12/31 14:13.
 */
public class WeekUtilTest {
    private int year = 2019;
    private int weekNo = 50;

    @Test
    public void getStartDayOfWeekNo() {
        String startDayOfWeekNo = WeekUtil.getStartDayOfWeekNo(year, weekNo);
        Assert.assertEquals("2019-12-09", startDayOfWeekNo);
    }

    @Test
    public void getEndDayOfWeekNo() {
        String endDayOfWeekNo = WeekUtil.getEndDayOfWeekNo(year, weekNo);
        Assert.assertEquals("2019-12-15", endDayOfWeekNo);
    }
}