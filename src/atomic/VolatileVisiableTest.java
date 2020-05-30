package atomic;

public class VolatileVisiableTest {

    private static   boolean initFlag = false;  //改了感知不到，副本本都是false
//    private static volatile  boolean initFlag = false;  //改了感知到，保证可见性
    public static void main(String[] args) throws InterruptedException {
      //模拟一个线程等待
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waitting data...");
                while (!initFlag){

//                    System.out.println(" System.out.println ...");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    for(int k=0;k<100000;k++){
                        new Object();
                    }
                }
                System.out.println("============success======");
            }
        }).start();

        Thread.sleep(2000);

        //模拟一个线程等待数据
        new Thread(new Runnable() {
            @Override
            public void run() {
            prepareData();
            }
        }).start();
    }

    public static void prepareData(){
        System.out.println("preparing data ...");
        initFlag = true;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("preparing data end...");
    }
}
