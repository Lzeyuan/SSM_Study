package com.shaoda.core.utils;

public class CalendarUtil {
    /**
     * 格式化日期
     * @param dateStr 字符型日期
     * @param format 格式
     * @return 返回日期
     */
    public static java.util.Date parseDate(String dateStr, String format) {
        java.util.Date date = null;
        try {
            java.text.DateFormat df = new java.text.SimpleDateFormat(format);
            String dt = dateStr;
            if ((!dt.equals("") && (dt.length() < format.length()))) {
                dt += format.substring(dt.length()).replace("[YyMmDdHhSs]","0");
            }
            date = (java.util.Date) df.parse(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 格式化输出日期
     * @param date 日期
     * @param format 格式
     * @return 返回字符型日期
     */
    public static String format(java.util.Date date, String format) {
        String reslut = "";
        try {
            if (date != null) {
                java.text.DateFormat df = new java.text.SimpleDateFormat(format);
                reslut = df.format(date);
            }
        } catch (Exception e) {
        }
        return reslut;
    }
    public static String format(java.util.Date date) {
        return  format(date,"yyyy-MM-dd");
    }
}
