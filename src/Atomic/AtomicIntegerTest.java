package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chunchen.meng on 2019/1/16.
 */
public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 20;
//    public static int count = 0;
//    public static volatile int count = 0;
    public static AtomicInteger count = new AtomicInteger(0);



    public static void increase() {
//        count++;
        count.incrementAndGet();
        System.out.println(count);
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
//        System.out.println(count);
    }
}
