package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * JMM
 * https://blog.csdn.net/mccand1234/article/details/52139319
 * Created by chunchen.meng on 2019/1/16.
 */
public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 200;
//    public static int count = 0;   //可能<20000,线程间没有可见性,以最后写入主内存的那个线程的count值为准.
//    public static volatile int count = 0; //也可能<20000
    public static AtomicInteger count = new AtomicInteger(0); //等于20000



    public static void increase() {
//    public synchronized static void increase() {
//        count++;  //不保证原子性，某个线程count++后assign后没有拿到lock，监听总线，将工作内存count失效，丢失本次++
        count.getAndIncrement();  //保证原子性，cas  or  count.incrementAndGet();
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
//        System.out.println("result is :"+count);
    }
}
