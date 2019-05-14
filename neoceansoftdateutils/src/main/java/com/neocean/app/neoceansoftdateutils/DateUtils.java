package com.neocean.app.neoceansoftdateutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/8.
 */

public class DateUtils {

    public static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat sDateFormatStr = new SimpleDateFormat("yyyy年MM月dd日");

    public static final SimpleDateFormat sTimeFormat = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat sTimeFormatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static final SimpleDateFormat sYear = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat sMonth = new SimpleDateFormat("MM");
    public static final SimpleDateFormat sDay = new SimpleDateFormat("dd");


    //    时间戳转换为日期格式
    public static String TimeStamp2Date(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats).format(new Date(timestamp));
        return date;
    }

    /**
     * 获取指定日期（不指定为当日）
     *
     * @param simpleDateFormat
     * @param dates
     * @return
     */
    public static String getTodayDate(SimpleDateFormat simpleDateFormat, Date... dates) {
        Date date = null;
        if (dates.length > 0) {
            date = dates[0];
        } else {
            date = new Date();
        }
        String str = simpleDateFormat.format(date);
        return str;

    }

    /**
     * 获取指定日期（不指定为当日）
     * 格式为 yyyy-MM-dd
     *
     * @param dates
     * @return
     */
    public static String getTodayDate(Date... dates) {
        Date date = null;
        if (dates.length > 0) {
            date = dates[0];
        } else {
            date = new Date();
        }
        String str = sDateFormat.format(date);
        return str;

    }

    /**
     * 获取当前日期
     * 格式 yyyy-MM-dd HH:mm
     *
     * @return
     */
    public static String getCurrentTime() {
        Date date = new Date();
        String str = sTimeFormatDate.format(date);
        return str;
    }

    /**
     * 获取当前日期
     * 指定格式日期
     *
     * @param simpleDateFormat
     * @return
     */
    public static String getCurrentTime(SimpleDateFormat simpleDateFormat) {
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        return str;
    }


    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static long getCurrentTimeLong() {
        long d = new Date().getTime() / 1000;
        return d;
    }

    /**
     * 时间戳转日期字符串
     *
     * @param time
     * @return
     */
    public static String getDateToString(long time) {
        Date d = new Date(time);
        return sTimeFormatDate.format(d);
    }

    /**
     * 将字符串转为时间戳
     * SimpleDateFormat simpleDateFormat 格式需要对应 需对应时间戳转日期字符串才不会产生误差
     */
    public static long getStringToDate(String time, SimpleDateFormat simpleDateFormat) {

        Date date = new Date();
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }


    /**
     * 时间戳中获取年
     *
     * @param time
     * @return
     */
    public static String getYearFromTime(long time) {
        Date d = new Date(time);

        return sYear.format(d);
    }

    /**
     * 时间戳中获取月
     *
     * @param time
     * @return
     */
    public static String getMonthFromTime(long time) {
        Date d = new Date(time);
        return sMonth.format(d);
    }

    /**
     * 时间戳中获取日
     *
     * @param time
     * @return
     */
    public static String getDayFromTime(long time) {
        Date d = new Date(time);

        return sDay.format(d);
    }


    /**
     * 判断是否闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeap(int year) {
        if (((year % 100 == 0) && year % 400 == 0) || ((year % 100 != 0) && year % 4 == 0))
            return true;
        else
            return false;
    }

    /**
     * 返回当月天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDays(int year, int month) {
        int days;
        int FebDay = 28;
        if (isLeap(year))
            FebDay = 29;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = FebDay;
                break;
            default:
                days = 0;
                break;
        }
        return days;
    }

    /**
     * 返回指定月的某个星期几的天数统计
     *
     * @param year
     * @param month
     * @param dayName
     * @return
     */
    public static int getSundays(int year, int month, String dayName) {
        int sundays = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Calendar setDate = Calendar.getInstance();
        //从第一天开始
        int day;
        for (day = 1; day <= getDays(year, month); day++) {
            setDate.set(Calendar.DATE, day);
            String str = sdf.format(setDate.getTime());
            if (str.equals(dayName)) {
                sundays++;
            }
        }
        return sundays;
    }


}
