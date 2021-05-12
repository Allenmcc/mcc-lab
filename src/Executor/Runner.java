package Executor;

/**
 * Created by chunchen.meng on 2018/9/17.
 */
public class Runner implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"");

        }

//    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new Runner());
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());
        Thread t3 = new Thread(new Runner());
        t2.start();

        t1.start();
        t0.start();
//        t0.sleep(5000);
        t0.join();


//        t1.sleep(1000);
//        t1.join();
//        t2.join();
        t3.start();
//        t3.join();

    }



}
