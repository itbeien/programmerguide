package com.beien.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author beien
 * @date 2023/3/5 16:35
 * Copyright© 2023 beien
 * 获取当前时间
 */
public class TimeUtil {
    /**
     * 秒（最小单位为秒，如果需要使用毫秒请自己乘以1000）
     */
    public static final int SECOND = 1;
    /**
     * 分（最小单位为秒，如果需要使用毫秒请自己乘以1000）
     */
    public static final int MINUTE = SECOND * 60;
    /**
     * 时（最小单位为秒，如果需要使用毫秒请自己乘以1000）
     */
    public static final int HOUR = MINUTE * 60;
    /**
     * 天（最小单位为秒，如果需要使用毫秒请自己乘以1000）
     */
    public static final int DAY = HOUR * 24;
    /**
     * 周（最小单位为秒，如果需要使用毫秒请自己乘以1000）
     */
    public static final int WEEK = DAY * 7;
    /**
     * 月--按照通用的30天计算，如需特殊值请另行计算（最小单位为秒，如果需要使用毫秒请自己乘以1000）
     */
    public static final int MONTH_30 = DAY * 30;
    /**
     * 年--按照通用的365天计算，如需特殊值请另行计算（最小单位为秒，如果需要使用毫秒请自己乘以1000）
     */
    public static final int YEAR_365 = DAY * 365;

    private final static int[] dayArr = new int[]{20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22};
    private final static int[] constellationArr = new int[]{10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final static int[] zodiacArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    /**
     * 将日期按照format格式转换成字符串
     *
     * @param date
     * @param format
     *
     * @return
     */
    public static String date2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将字符串按照format格式转换成日期类型
     *
     * @param date
     * @param format
     *
     * @return
     *
     * @throws ParseException
     */
    public static Date string2Date(String date, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    /**
     * 将指定的字符串日期格式转换成其他形式的日期字符串
     *
     * @param date 日期字符串
     * @param sourceFormat 原日期字符串格式
     * @param toFormat 新日期字符串格式
     *
     * @return
     *
     * @throws ParseException
     */
    public static String stringDateToFormat(String date, String sourceFormat, String toFormat) throws ParseException {
        Date sourceDate = new SimpleDateFormat(sourceFormat).parse(date);
        return new SimpleDateFormat(toFormat).format(sourceDate);
    }

    /**
     * 获取当前时间戳的毫秒值
     *
     * @return
     */
    public static long getTimestamp() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * 返回指定格式的当前日期
     *
     * @param format
     *
     * @return
     */
    public static String getNow(String format) {
        return date2String(new Date(), format);
    }

    /**
     * 获取以指定时间为基准的前后N天的日期
     *
     * @param date： 指定日期
     * @param days：days > 0 = 未来时间、days < 0 = 历史时间、days == 0 = 当前时间
     *
     * @return
     */
    public static Date dateForBeforeOrAfter(Date date, int days) {
        // 使用默认时区和语言环境获得一个日历。
        Calendar cal = Calendar.getInstance();
        if (null != date) {
            cal.setTime(date);
        }
        cal.add(Calendar.DAY_OF_YEAR, +days);
        return cal.getTime();
    }

    /**
     * 将毫秒值转换成指定format格式的日期
     *
     * @param millSeconds
     *
     * @return
     */
    public static String millisecond2String(long millSeconds, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millSeconds);
        return date2String(cal.getTime(), format);
    }


    /**
     * 获取以当前天为基准的前/后第N天的23:59:59的时间戳值，如需UnixTime请自行 / 1000
     *
     * @param days：days > 0 = 未来时间、days < 0 = 历史时间、days == 0 = 当前时间
     *
     * @return
     */
    public static long getLastTimeStampForDay(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, +days);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime().getTime();
    }

    /**
     * 获取当月最后一天23:59:59的时间戳值，如需UnixTime请自行 / 1000
     *
     * @return
     */
    public static long getMonthLastDayForTimeStamp() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime().getTime();
    }

    /**
     * 当dayOfWeek==0时，获取指定日期所在周的周一对应的日期；
     * 在此基础上通过addDayOfWeek参数来灵活获取相关周的任意周几的日期；
     * 其思路就是先拿到指定日期所在周的周一对应日期，然后通过增减天数来获取上周，本周甚至任意周的任意周几日期；
     * 例如：
     * <pre>
     *     1. 获取当前日期所在周的周一日期：getDayOfWeekForDate(new Date(), 0);
     *     2. 获取当前日期所在周的周三日期；getDayOfWeekForDate(new Date(), 2);
     *     3. 获取当前日期所在周的周日日期；getDayOfWeekForDate(new Date(), 6);
     *     4. 获取当前日期的前一周的周一日期：getDayOfWeekForDate(new Date(), -7);
     *     5. 获取当前日期的前一周的周日日期：getDayOfWeekForDate(new Date(), -1);
     *     6. 获取当前日期的未来一周的周一日期：getDayOfWeekForDate(new Date(), 7);
     * </pre>
     *
     * @param date：指定日期
     * @param addDayOfWeek：指定日期所在周周一的基础上加几天或者减几天的日期
     *
     * @return
     */
    public static Date getDayOfWeekForDate(Date date, int addDayOfWeek) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, addDayOfWeek);
        return cal.getTime();
    }

    /**
     * 非标出生日期格式化方法，转换后统一使用标准格式yyyy-mm-dd
     *
     * @param sourceBirthday：原非标出生日期；该非标日期要求必须具备年、月、日，缺一不可； <pre>
     * <ul>
     * 例：
     *  <li>1989年-----------------false</li>
     *  <li>2月26日-----------------false</li>
     *  <li>1980年2月1日-------------true</li>
     *  <li>1988.02.01-------------true</li>
     *  <li>1990/03/3--------------true</li>
     * </ul>
     * </pre>
     *
     * @return
     *
     * @throws Exception
     */
    public static String convertBirthday(String sourceBirthday) throws Exception {
        String targetBirthday = null;
        if (StringUtils.isNotBlank(sourceBirthday)) {
            sourceBirthday = sourceBirthday.replaceAll(" ", "");
            sourceBirthday = sourceBirthday.replaceAll("[生出]", "");
            sourceBirthday = sourceBirthday.replaceAll("号", "日");
            if (sourceBirthday.matches("(\\d{4})[年](\\d{2}|\\d{1})[月](\\d{2}|\\d{1})[日]")) {
                targetBirthday = date2String(string2Date(sourceBirthday, "yyyy年m月d日"), "yyyy-mm-dd");
            } else if (sourceBirthday.matches("(\\d{4})[.](\\d{2}|\\d{1})[.](\\d{2}|\\d{1})")) {
                targetBirthday = date2String(string2Date(sourceBirthday, "yyyy.m.d"), "yyyy-mm-dd");
            } else if (sourceBirthday.matches("(\\d{4})[/](\\d{2}|\\d{1})[/](\\d{2}|\\d{1})")) {
                targetBirthday = date2String(string2Date(sourceBirthday, "yyyy/m/d"), "yyyy-mm-dd");
            } else if (sourceBirthday.matches("(\\d{4})[-](\\d{2}|\\d{1})[-](\\d{2}|\\d{1})")) {
                targetBirthday = date2String(string2Date(sourceBirthday, "yyyy-m-d"), "yyyy-mm-dd");
            } else if (sourceBirthday.matches("(\\d{4})[年](\\d{2}|\\d{1})[月](\\d{2}|\\d{1})")) {
                targetBirthday = date2String(string2Date(sourceBirthday, "yyyy年m月d"), "yyyy-mm-dd");
            } else if (sourceBirthday.matches("\\d{8}")) {
                targetBirthday = date2String(string2Date(sourceBirthday, "yyyymmdd"), "yyyy-mm-dd");
            }
        }
        return targetBirthday;
    }


    /**
     * 获取今年是哪一年
     *
     * @return
     */
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

    /**
     * 获取本月是哪一月
     *
     * @return
     */
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    /**
     * 获取某年某月到某年某月按天的切片日期集合（间隔天数的集合）
     *
     * @param beginYear
     * @param beginMonth
     * @param endYear
     * @param endMonth
     * @param k
     *
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List getTimeList(int beginYear, int beginMonth, int endYear, int endMonth, int k) {
        List list = new ArrayList();
        if (beginYear == endYear) {
            for (int j = beginMonth; j <= endMonth; j++) {
                list.add(getTimeList(beginYear, j, k));
            }
        } else {
            {
                for (int j = beginMonth; j < 12; j++) {
                    list.add(getTimeList(beginYear, j, k));
                }
                for (int i = beginYear + 1; i < endYear; i++) {
                    for (int j = 0; j < 12; j++) {
                        list.add(getTimeList(i, j, k));
                    }
                }
                for (int j = 0; j <= endMonth; j++) {
                    list.add(getTimeList(endYear, j, k));
                }
            }
        }
        return list;
    }

    /**
     * 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
     *
     * @param beginYear
     * @param beginMonth
     * @param k
     *
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static List getTimeList(int beginYear, int beginMonth, int k) {
        List list = new ArrayList();
        Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }

    /**
     * 获取两个日期中的最大日期
     *
     * @param beginDate
     * @param endDate
     *
     * @return
     */
    public static Date max(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return beginDate;
        }
        return endDate;
    }

    /**
     * 获取两个日期中的最小日期
     *
     * @param beginDate
     * @param endDate
     *
     * @return
     */
    public static Date min(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }

    /**
     * 计算两个日期相差/相隔的天数
     * 相差：date = "yyyy-MM-dd HH:mm:ss"
     * 相隔：date = "yyyy-MM-dd";
     *
     * @param date
     * @param otherDate
     *
     * @return
     */
    public static long calculateTwoDayDifferences(Date date, Date otherDate) {
        return (date.getTime() - otherDate.getTime()) / (DAY * 1000);
    }

    /**
     * 获取指定日期所在月的第一天
     *
     * @return
     */
    public static Date getMonthFirstDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取指定日期所在月的最后一天
     *
     * @return
     */
    public static Date getMonthLastDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 返回当前日期是周几
     *
     * @param date
     * @return int
     */
    public static int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
}
