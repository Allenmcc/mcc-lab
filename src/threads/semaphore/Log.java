package threads.semaphore;

/**
 * Created by chunchen.meng on 2019/2/13.
 */
public class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}
