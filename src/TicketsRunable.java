/**
 * Created by danny on 16/3/19.
 */

//class MyThread2 implements Runnable{
//    private int ticketCount = 5;
//
//    @Override
//    public void run() {
//        while (ticketCount > 0){
//            ticketCount -- ;
//            System.out.println(Thread.currentThread().getName() + "卖了1张票，剩余票数为:"+ticketCount);
//        }
//    }
//
//}
//public class TicketsRunable {
//
//    public static void main(String[] args){
//        MyThread2 mt =new MyThread2();
//       //创建3个线程来模拟三个窗口售票
//        Thread th1 = new Thread(mt,"窗口1");
//        Thread th2 = new Thread(mt,"窗口2");
//        Thread th3 = new Thread(mt,"窗口3");
//        //启动这三个线程，即窗口，开始卖票
//        th1.start();
//        th2.start();
//        th3.start();
//
//
//    }
//}

//package com.threadtest;
class MyThread1 implements Runnable{
    private  int ticket =200;
    private String name;
    public  void run(){
//        for(int i =0;i<500;i++){
        while (true){
            synchronized(this) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "第" + "次" + "卖票---->" + (this.ticket--));
                }
            }
        }
    }
}
public class TicketsRunable {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //设计三个线程
        MyThread1 mt = new MyThread1();
        Thread t1 = new Thread(mt,"一号窗口");
        Thread t2 = new Thread(mt,"二号窗口");
        Thread t3 = new Thread(mt,"三号窗口");
//         MyThread1 mt2 = new MyThread1();
//         MyThread1 mt3 = new MyThread1();
        t1.start();
        t2.start();
        t3.start();
    }

}
