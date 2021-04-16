package threadlocal; /**
 * Created by danny on 2016/12/28.
 */

import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;

public class TestInheritableThreadLocal extends TestCase {

    public void testThreadLocal() {
        final ThreadLocal<String> local = new ThreadLocal<String>();
        work(local);
    }

    public void testInheritableThreadLocal() {
        final ThreadLocal<String> local = new InheritableThreadLocal<String>();
        work(local);
    }

    private void work(final ThreadLocal<String> local) {
        local.set("a");
        out.println(Thread.currentThread() + "," + local.get());
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                out.println(Thread.currentThread() + "," + local.get());
                local.set("b");
                out.println(Thread.currentThread() + "," + local.get());
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        out.println(Thread.currentThread() + "," + local.get());
    }


    /**
     * https://www.cnblogs.com/hama1993/p/10400265.html
     */
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);
    private static ThreadLocal tl = new InheritableThreadLocal<>();

    @Test
    public void testExecutorPoolThreadLocal() {
// 为了方便观察，我们假定线程池里只有一个线程

        tl.set(1);

        System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        executorService.execute(() -> {
            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        });

        executorService.execute(() -> {
            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        });

        System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

    }

    @Test
    public void testExecutorPoolThreadLocal2() {
        System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

        executorService.execute(() -> {
            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        });

        tl.set(1); // 等上面的线程池第一次启用完了，父线程再给自己赋值

        executorService.execute(() -> {
            System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));
        });

        System.out.println(String.format("线程名称-%s, 变量值=%s", Thread.currentThread().getName(), tl.get()));

    }
}
