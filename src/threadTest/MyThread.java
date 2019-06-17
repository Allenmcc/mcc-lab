package threadTest;

/**
 * Created by chunchen.meng on 2019/5/24.
 */
// Demo.java 的源码
class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running");
    }
};

