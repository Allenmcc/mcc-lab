package atomic;


import java.util.concurrent.TimeUnit;

public class VolatileVisiableObject2Test {

//    public static int[] array = new int[10];
    public static volatile int[] array = new int[10];
    public static void main(String[] args) {
        new Thread(() -> {  //线程A
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                array[0] = 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(()->{   //线程B  先执行
            try {
                while (true) {
                    if (array[0] == 2) {
//                        System.out.println("结束");
                        break;
                    }
//                    Thread.sleep(10);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}


