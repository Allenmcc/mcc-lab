package threadTest;

/**
 * Created by chunchen.meng on 2019/6/19.
 * java中的sleep()和wait()的区别
 * https://www.cnblogs.com/hongten/p/hongten_java_sleep_wait.html
 */
public class SleepAndWaitTest {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (SleepAndWaitTest.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
//                    SleepAndWaitTest.class.wait();
//                    带参数的wait(1000),时间一到就进入锁池状态，不需要notify
                    SleepAndWaitTest.class.wait(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (SleepAndWaitTest.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                SleepAndWaitTest.class.notify();
                //==================
                //区别
                //如果我们把代码：SleepAndWaitTest.class.notify();给注释掉，SleepAndWaitTest.class调用了wait()方法，但是没有调用notify()
                //方法，则线程1永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu给其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁！！！ object's monitor
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }


}
