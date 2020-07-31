package Executor;

import org.junit.Test;

import java.lang.management.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ManagementFactory是一个为我们提供各种获取JVM信息的工厂类，使用ManagementFactory可以获取大量的运行时JVM信息，
 * 比如JVM堆的使用情况，以及GC情况，线程信息等，通过这些数据项我们可以了解正在运行的JVM的情况，以便我们可以做出相应的调整。
 * 本文将基于ManagementFactory，介绍如何通过ManagementFactory获取一些运行时的JVM信息，下面首先展示了ManagementFactory的类图，
 * 可以看出它提供了大量的工厂方法，使得我们可以通过调用这些方法来获取运行时的相关Bean，通过这些Bean就可以获取到我们想要的数据：
 https://www.jianshu.com/p/5d854245051d

 */
public class ExecutorPoolTest {

    @Test
    public void shutdown() throws Exception {        //用于获取到本java进程，进而获取总线程数

        //就应该知道年轻代、老年代、永久代等相关概念，
        //下面的类是获取这些内存信息的根据类，其中包含了详细的JVM运行时内存信息，甚至包括了堆外内存信息。
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        /**
         * MemoryUsage
         * Init：java虚拟机在启动的时候向操作系统请求的初始内存容量，java虚拟机在运行的过程中可能向操作系统请求更多的内存或将内存释放给操作系统，
         * 所以init的值是不确定的。
         * Used：当前已经使用的内存量。
         * Committed：表示保证java虚拟机能使用的内存量，已提交的内存量可以随时间而变化（增加或减少）。
         * Java 虚拟机可能会将内存释放给系统，committed 可以小于 init。committed 将始终大于或等于 used。
         * Max：表示可以用于内存管理的最大内存量（以字节为单位）。可以不定义其值。如果定义了该值，最大内存量可能随时间而更改。
         * 已使用的内存量和已提 交的内存量将始终小于或等于 max（如果定义了 max）。
         * 如果内存分配试图增加满足以下条件的已使用内存将会失败：used > committed，即使 used <= max 仍然为 true（例如，当系统的虚拟内存不足时）。
         */
        System.out.println(memoryMXBean.getHeapMemoryUsage());

        //使用ClassLoadingMXBean可以获取当前JVM的类加载信息
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println(classLoadingMXBean.getLoadedClassCount());


        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        String jvmName = runtimeBean.getName();
        System.out.println("JVM Name = " + jvmName);
        long pid = Long.valueOf(jvmName.split("@")[0]);
        System.out.println("JVM PID  = " + pid);
        //通过ThreadMXBean提供的方法，我们可以获取详细的运行时JVM内的线程信息
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
            System.out.println("1:" + Thread.currentThread().getName());
            for (int j = 0; j < 5; j++) {
                executor.execute(() -> {
                    System.out.println("2:" + Thread.currentThread().getName());
                    System.out.println("当前线程总数为：" + bean.getThreadCount());
                });
            }
            //test
//            executor.shutdown();
        }
        Thread.sleep(10000);
        System.out.println("last线程总数为 = " + bean.getThreadCount());
    }

}
