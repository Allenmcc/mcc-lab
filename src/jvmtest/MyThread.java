package jvmtest;

/**
 * Created by chunchen.meng on 2019/3/26.
 */
public class MyThread extends Thread{

    public static void main(String[] args) {

        System.out.println("0.主线程");

//
//        MyThread mt1 = new MyThread("Thread a");
//        MyThread mt2 = new MyThread("Thread b");
//
//        mt1.setName("My-Thread-1 ");
//        mt2.setName("My-Thread-2 ");
//
//        mt1.start();
//        mt2.start();
        new Thread(() -> {
            System.out.println("1.");
            }, "11").start();
        new Thread(() -> {
            System.out.println("2");
            }, "22").start();
        System.out.println("3.主线程");
        System.out.println("4.主线程");
    }

    public MyThread(String name) {
        System.out.println(name);
    }

    @Override
    public void run() {

        while (true) {

        }
    }
}
