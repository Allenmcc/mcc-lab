package Executor;

/**
 * 1.当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * 2.当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
 * 3.当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
 * 4.当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
 *
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        SynchronizedTest  synchronizedTest = new SynchronizedTest();
//        new Thread(()->synchronizedTest.m1(),"thread1").start();
//        new Thread(()->synchronizedTest.m1(),"thread2").start();
//        new Thread(()->synchronizedTest.m2(),"thread3").start();
//        new Thread(()->synchronizedTest.m2(),"thread4").start();


        new Thread(()->synchronizedTest.m3(1),"thread5").start();
        new Thread(()->synchronizedTest.m3(2),"thread6").start();
        new Thread(()->synchronizedTest.m3("a"),"thread7").start();
    }

    private   synchronized void m1(){

        try {
            System.out.println("m1 is running:"+Thread.currentThread().getName());
            m2();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1 is end:"+Thread.currentThread().getName());


    }

    private   void m2(){

        try {
            System.out.println("m2 is running:"+Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 is end:"+Thread.currentThread().getName());

    }

    private <T> void m3(T o) {

        System.out.println(o.getClass());
        try {
            //o 为1 和2 不用竞争  2和2需要竞争
//            synchronized (o) {
            //锁当前类型
            synchronized (o.getClass()) {
                //锁当前类
//            synchronized (this) {
                System.out.println("m3 is running:" + Thread.currentThread().getName());
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m3 is end:" + Thread.currentThread().getName());

    }
}
