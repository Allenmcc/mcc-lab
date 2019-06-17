package threadTest;

/**
 * Created by chunchen.meng on 2019/5/24.
 */
public class Demo {
    public static void main(String[] args) {
        Thread mythread=new MyThread("mythread");

        System.out.println(Thread.currentThread().getName()+" call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName()+" call mythread.start()");
        mythread.start();
    }
}
