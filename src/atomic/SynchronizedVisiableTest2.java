package atomic;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

//@Log

//Synchronized 会同步全部共享变量
public class SynchronizedVisiableTest2 {

    private static boolean is = true;
    private static boolean is2 = true;

//    public static Logger logger = LoggerFactory.getLogger(SynchronizedVisiableTest2.class);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (is) {
                    i++;
//                    log.info("t");
//                    if(is){
//                        System.out.println("is is true");
//                    }

//                    if(is2){
//                        System.out.println("is2 is true");
//                    }

                     synchronized (this) { } //会强制刷新主内存的变量值到线程栈
//                     System.out.println("1"); //println 是synchronized 的,会强制刷新主内存的变量值到线程栈?
//                     System.out.println(is2); //println 是synchronized 的,会强制刷新主内存的变量值到线程栈?
//                     sleep 会从新load主内存的值?
//                        try {
//                           TimeUnit.MICROSECONDS.sleep(1);
//                       }catch (InterruptedException e) {
//                          e.printStackTrace();
//                       }
//                    for(int k=0;k<100000;k++){
//                        new Object();
//                    }
                }

//                if(is2){
//                    System.out.println("is2_2 is true");
//                }else {
//                    System.out.println("is2_2 is false");
//                }

                while (!is2){

                    //不停说明没有拿了最新的is2
                }
            }
        }).start();



//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                is2 = false;
//            }
//        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                is = false;  //设置is为false，使上面的线程结束while循环
                is2 = false;
            }
        }).start();
    }

}
