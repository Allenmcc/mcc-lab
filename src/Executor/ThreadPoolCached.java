package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chunchen.meng on 2019/5/23.
 *https://blog.csdn.net/q438944209/article/details/82923024
 *
 * 发现10个线程都是使用的线程1，线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 */

public class ThreadPoolCached {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //当线程池小于corePoolSize时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程
//        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);
//        ExecutorService cachedThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
//                System.out.println(index + "当前线程1" + Thread.currentThread().getName());

                //newCachedThreadPool  不sleep 会使用多个线程，任务长会将使用完的线程重新利用,而不是新建线程
                Thread.sleep(index * 100);
            } catch (Exception e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index + "当前线程" + Thread.currentThread().getName());
                }
            });
        }

        cachedThreadPool.shutdown();

    }
}