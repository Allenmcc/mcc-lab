package Executor;

import lombok.Data;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by chunchen.meng on 2017/12/18.
 * https://blog.csdn.net/suifeng629/article/details/98884972
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
            System.out.println("Thread is : "+Thread.currentThread());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Date endTime = new Date();
            System.out.println(sdf.format(endTime));


        }
    }


    /**
     * 默认拒绝策略为AbortPolicy
     * 即丢弃任务并抛出RejectedExecutionException异常
     */
    @Test
    public void testAboardPolicy(){

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.SECONDS, queue, factory);
        //丢弃不抛出异常
//                0L, TimeUnit.SECONDS, queue, factory,new ThreadPoolExecutor.DiscardPolicy());
//        ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新提交被拒绝的任务。
//                0L, TimeUnit.SECONDS, queue, factory,new ThreadPoolExecutor.DiscardOldestPolicy());
        while (true) {
            executor.submit(() -> {
                try {
                    System.out.println(queue.size());
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    /**
     * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
     */
    @Test
    public void testCallerRunsPolicy(){

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":执行任务");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
