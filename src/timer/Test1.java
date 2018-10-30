package timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by chunchen.meng on 2018/9/24.
 */
public class Test1 {
    public static void main(String[] args){
        System.out.println("当前时间："+new Date());
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,1);
        Date date=calendar.getTime();
        MyTask task=new MyTask();
        Timer timer=new Timer();
//        Timer timer=new Timer(true);
        timer.schedule(task,date);
    }

}
