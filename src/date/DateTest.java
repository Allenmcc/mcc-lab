package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by danny on 16/4/20.
 */
public class DateTest {
    public static void main(String arg[]) throws ParseException {

//        String sdate;
//        Date ddate = new Date();
//
//        sdate=(new SimpleDateFormat("yyyy-MM-dd")).format(ddate);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(ddate);
//        cal.add(Calendar.MONTH, -1);
//
//        String sdate2;
//        Date ddate2 = cal.getTime();
//        sdate2 = (new SimpleDateFormat("yyyy-MM-dd")).format(ddate2);
//        System.out.println(sdate);
//
//        System.out.println(sdate2);
//        System.out.println(getQuarter());
//        System.out.println(getCurrQuarter(4));
        System.out.println(getQuarterEndTime(new Date()));

        System.out.println(timeStamp2Date("1461340800000",null));

        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);

        System.out.println(dft.format(date.getTime()));

        Date endDate = dft.parse(dft.format(date.getTime()));


        System.out.println(dft.format(date.getTime()));
        System.out.println(endDate);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        System.out.println(c.getTime());

        Date date1 = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        System.out.println(f.format(date1));

    }

    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 获取当前季度
     *
     */
    public static String getQuarter() {
        Calendar c = Calendar.getInstance();
        int month = c.get(c.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return quarter + "";
    }

    /**
     * 获取某季度的第一天和最后一天
     *	@param num 第几季度
     */
    public static String[] getCurrQuarter(int num) {
        String[] s = new String[2];
        String str = "";
        // 设置本年的季
        Calendar quarterCalendar = null;
        switch (num) {
            case 1: // 本年到现在经过了一个季度，在加上前4个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 3);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = formatDate(quarterCalendar.getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "01-01";
                s[1] = str;
                break;
            case 2: // 本年到现在经过了二个季度，在加上前三个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 6);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = formatDate(quarterCalendar.getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "04-01";
                s[1] = str;
                break;
            case 3:// 本年到现在经过了三个季度，在加上前二个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 9);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = formatDate(quarterCalendar.getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "07-01";
                s[1] = str;
                break;
            case 4:// 本年到现在经过了四个季度，在加上前一个季度
                quarterCalendar = Calendar.getInstance();
                str = formatDate(quarterCalendar.getTime(), "yyyy-MM-dd");
                s[0] = str.substring(0, str.length() - 5) + "10-01";
                s[1] = str.substring(0, str.length() - 5) + "12-31";
                break;
        }
        return s;
    }

    /**
     * 用途：以指定的格式格式化日期字符串
     *
     * @param pattern     字符串的格式
     * @param currentDate 被格式化日期
     * @return String 已格式化的日期字符串
     * @throws NullPointerException 如果参数为空
     */
    public static String formatDate(Date currentDate, String pattern) {
        if (currentDate == null || "".equals(pattern) || pattern == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(currentDate);
    }


    /**
     * 当前季度的结束时间
     *
     * @return
     */
    public static Date getQuarterEndTime(Date date) {
         final  SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
         final  SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date dt = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            dt = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59.999");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }



}
