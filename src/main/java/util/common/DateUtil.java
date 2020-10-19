package util.common;

import util.helper.DatePattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by liangjj on 2017/9/14.
 */
class DateUtil {
    private static final Locale china = Locale.CHINA;

    private DateUtil() {
    }

    /**
     * 获取当前年月日（示例：2017-09-14）
     *
     * @param datePattern
     * @return 返回 String 对象
     */
    static String getDateByPattern(DatePattern datePattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern.toString(), china);
        return simpleDateFormat.format(date);
    }

    /**
     * 将毫秒数转换为字符串的日期类型
     *
     * @param millis
     * @return
     */
    static String convertMillisToDate(long millis) {
        Date date = new Date(millis);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DatePattern.YMDHMS.toString(), china);
        return simpleDateFormat.format(date);
    }

    /**
     * 用于判断活动是否开始
     *
     * @param startTime 比如：2020-07-28 00:00:00
     * @param endTime 比如：2020-08-28 23:59:59
     * @return
     */
    static boolean isStarted(String startTime, String endTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DatePattern.YMDHMS.toString());
        boolean started = false;
        try {
            Date startDate = simpleDateFormat.parse(startTime);
            Date endDate = simpleDateFormat.parse(endTime);
            Date date = new Date();
            long time = date.getTime();
            if (startDate.getTime() <= time && time <= endDate.getTime()) {
                started = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return started;
    }
}
