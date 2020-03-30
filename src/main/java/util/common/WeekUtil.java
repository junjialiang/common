package util.common;

import java.util.Calendar;

/**
 * 获得指定年与周的开始日期和结束日期（格式为：2019-12-09）
 * Created by Junjia on 2019/11/18 11:21.
 */
class WeekUtil {
    private WeekUtil() {
    }

    /**
     * get start date of given week no of a year
     *
     * @param year
     * @param weekNo
     * @return
     */
    static String getStartDayOfWeekNo(int year, int weekNo) {
        Calendar cal = getCalendarFromYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        return getDate(cal);
    }

    /**
     * get the end day of given week no of a year.
     *
     * @param year
     * @param weekNo
     * @return
     */
    static String getEndDayOfWeekNo(int year, int weekNo) {
        Calendar cal = getCalendarFromYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return getDate(cal);
    }

    /**
     * get Calendar of given year
     *
     * @param year
     * @return
     */
    private static Calendar getCalendarFromYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    /**
     * 获得年月日（示例：2019-12-09）
     *
     * @param cal
     * @return
     */
    private static String getDate(Calendar cal) {
        int month = cal.get(Calendar.MONTH) + 1;
        String formatMonth = String.format("%02d", month);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String formatDay = String.format("%02d", day);
        return cal.get(Calendar.YEAR) + "-" + formatMonth + "-" + formatDay;
    }
}