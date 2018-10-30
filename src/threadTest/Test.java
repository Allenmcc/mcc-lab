package threadTest;

import java.util.Timer;

/**
 * Created by chunchen.meng on 2018/9/24.
 */
public class Test {
    public static Object object = new Object();
    public static void main(String[] args) {
        Thread0 thread0 = new Thread0();
        Thread1 thread1 = new Thread1();

        thread0.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Timer timer=new Timer();

        thread1.start();
    }

    static class Thread0 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                }
                System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
            }
        }
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");
            }
            System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
        }
    }

}
