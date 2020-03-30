package util.common;

import util.helper.DatePattern;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by liangjj on 2017/9/14.
 */
class DateUtil {
    private static Locale china = Locale.CHINA;

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

//    /**
//     * 输入天数后将返回毫秒数
//     *
//     * @param days
//     * @return
//     */
//    static long getMillisecondFromDays(int days) {
//        // 一天等于86400000毫秒
//        return days * 86400000L;
//    }
}
