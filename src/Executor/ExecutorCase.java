package Executor;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by chunchen.meng on 2017/12/18.
 */
public class ExecutorCase {
    private static Executor  executor=  new ThreadPoolExecutor(
            2, 5,
            1L, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());
//    private static Executor  executor= Executors.newFixedThreadPool(10);
    public static void main(String[] args){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//显示2017-10-27 10:00:00格式
//        long startTime = System.currentTimeMillis();
        Date startTime = new Date();
////        for (int i=0;i<10;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            executor.execute(new Task());

//        }

        Date endTime = new Date();
        System.out.println("程序执行时间："+sdf.format(startTime)+" "+sdf.format(endTime));

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//显示2017-10-27 10:00:00格式


            Date startTime = new Date();
            System.out.println(sdf.format(startTime));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Date endTime = new Date();
            System.out.println(sdf.format(endTime));


        }
    }
}
