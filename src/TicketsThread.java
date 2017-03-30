/**
 * Created by danny on 16/3/19.
 */

class MyThread extends Thread {

    private int ticket = 5;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            if (this.ticket > 0) {
                System.out.println(this.name + "第"+i+"次卖票---->" + (this.ticket--));
            }
        }
    }
}

public class TicketsThread {

    public static void main(String[] args) {
        //创建三个线程，模拟三个窗口卖票
        MyThread mt1 = new MyThread("一号窗口");
        MyThread mt2 = new MyThread("二号窗口");
        MyThread mt3 = new MyThread("三号窗口");


        //启动这三个线程，即窗口，开始卖票
        mt1.start();
        mt2.start();
        mt3.start();
    }

}
