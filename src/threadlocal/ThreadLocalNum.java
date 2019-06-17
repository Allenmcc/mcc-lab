package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danny on 2016/12/31.
 */
public class ThreadLocalNum {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    // ②获取下一个序列值
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        System.out.println("getNextNum thread[" + Thread.currentThread().getName() + "] --> sn["
                + seqNum.get() + "]");
        return seqNum.get();
    }


    private static final ThreadLocal<SimpleDateFormat> format = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
    };

    private static ThreadLocal<String> requestStartTime = new ThreadLocal<String>();


    public static void main(String[] args) {
        ThreadLocalNum sn = new ThreadLocalNum();
        // ③ 3个线程共享sn，各自产生序列号(TestClient 里面的成员变量)
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();


        System.out.println("currend Theread:"+Thread.currentThread().getName());
        System.out.println("format init:"+format.get());
        requestStartTime.set(format.get().format(new Date()));
        System.out.println("requestStartTime init:"+requestStartTime.get());

    }

    private static class TestClient extends Thread {
        private ThreadLocalNum sn;

        public TestClient(ThreadLocalNum sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 4; i++) {
                // ④每个线程打出4个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + sn.getNextNum() + "]");
            }
        }
    }
}  
