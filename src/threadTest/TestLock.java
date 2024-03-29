package threadTest;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        //不安全出现-1
//       TestLock2 testLock2 =  new TestLock2();
        //安全
       SafeLock testLock2 =  new SafeLock();
       //3个线程操作一个对象
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements Runnable{

    int ticketNums = 10;
    //定义lock锁 安全+常量
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            if(ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println(ticketNums--);
            }else {
                break;
            }

        }
    }
}

class SafeLock implements Runnable{

    int ticketNums = 10;
    //定义lock锁 安全+常量
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();

                if(ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }

            }finally {
                //解锁
                lock.unlock();

            }


        }
    }
}
