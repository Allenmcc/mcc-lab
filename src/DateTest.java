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

        System.out.println(timeStamp2Date("1461340800000",null));

        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        Date endDate = dft.parse(dft.format(date.getTime()));
        System.out.println(endDate);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        System.out.println(c.getTime());

    }

    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }
}
