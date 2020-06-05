package atomic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class VolatileVisiableObjectTest {

    private   Map<Integer,Integer> maptest = new HashMap(16);  //改了感知不到，副本本都是false


//    private static volatile  boolean initFlag = false;  //改了感知到，保证可见性

    @Test
//    public static void main(String[] args) throws InterruptedException {
    public void testVolatile() {
        maptest.put(1, 0);
        //模拟一个线程等待
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waitting data...");
                while ( maptest.get(1).equals(0)) {

                }
                System.out.println("============success======");
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //模拟一个线程等待数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("preparing data ...");
                maptest.put(1, 1);
                System.out.println("preparing data end...");
            }
        }).start();
    }

//    public static void prepareData(){
//        System.out.println("preparing data ...");
//        maptest.put("initFlag",true);
////        initFlag = true;
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        System.out.println("preparing data end...");
//    }
}
