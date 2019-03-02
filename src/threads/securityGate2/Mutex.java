package threads.securityGate2;


//https://blog.csdn.net/u011521203/article/details/80186741
//reentrantlock
public final class Mutex {
    private long locks = 0;
    private Thread owner = null;
    public synchronized void lock() {
        Thread me = Thread.currentThread();

        //解决同一个线程多次lock() 等待的问题
        while (locks > 0 && owner != me) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        assert locks == 0 || owner == me;
        owner = me;
        locks++;
    }


    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        //解决只有自己可以解锁的问题
        if (locks == 0 || owner != me) {
            return;
        }
        assert locks > 0 && owner == me;
        locks--;
        if (locks == 0) {
            owner = null;
            notifyAll();
        }
    }


    //限制1.不可重入 限制2.任何人都可以unlock
//    private boolean busy = false;
//    public synchronized void lock() {
//        while (busy) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//            }
//        }
//        busy = true;
//    }
//    public synchronized void unlock() {
//        busy = false;
//        notifyAll();
//    }
}
