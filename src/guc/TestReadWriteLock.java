package guc;

/**
 * https://www.cnblogs.com/alsf/p/9136668.html
 * ReadWriteLock 维护了一对相关的锁，一个用于只读操作，另一个用于写入操作。只要没有 writer，读取锁可以由多个 reader 线程同时保持。写入锁是独占的。
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(new Runnable() {

            @Override
            public void run() {
                rw.set((int)(Math.random() * 101));
            }
        }, "Write:").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }
    }
}
