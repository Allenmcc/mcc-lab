
/**
 * Created by danny on 15/12/18.
 */

public class ThreadTest implements Runnable{
    //下面两个静态成员变量需要通过用关键字synchronized修饰 的方法来访问
    private static int min = Integer.MAX_VALUE;        //初始最小值
    private static int max = Integer.MIN_VALUE;            //初始最大值

    //下面为成员变量,每个线程对象私有
    private int[] nums;            //待查找数组
    private int low;                  //当前线程对象需要处理的数组开始下标
    private int high;                 //当前线程对象需要处理的数组结束下标

    //构造方法，传入待查找数组、开始下标和结束下标
    public ThreadTest(int[] nums, int low, int high){
        this.nums = nums;
        this.low = low;
        this.high = high;
    }

    //线程run方法
    @Override
    public void run() {
        //在当前线程负责的数组部分里面查找最小、最大值
        for(int i=low; i<=high; i++){
            if(nums[i]<min) {
                ThreadTest.setMin(nums[i]);
            }
            else if(nums[i]>max) {
                ThreadTest.setMax(nums[i]);
            }
        }
    }

    //下面为各个对静态成员变量加锁的访问方法
    public static synchronized int getMin() {
        return min;
    }
    public static synchronized void setMin(int min) {
        ThreadTest.min = min;
    }
    public static synchronized int getMax() {
        return max;
    }
    public static synchronized void setMax(int max) {
        ThreadTest.max = max;
    }


    //程序入口，main方法
    public static void main(String[] args) throws InterruptedException {
        String path = "/Users/danny/Downloads/num";

        long beginWrite = System.currentTimeMillis();
        NumWrite.writeTxt(path);
        long endWrite = System.currentTimeMillis();

        long beginRead = System.currentTimeMillis();
        int[] nums = NumWrite.readFileByLines(path);
        long endRead = System.currentTimeMillis();

        //测试数组
//        int[] nums = new int[]{8,4,5,1,5,7,5,4,45,45,4,8,7,8,7,7,8,9,5,4,9,5,5,4,9,8,7,44,5,55,6,6,3,6,5,4,6,8,7,5,6,5,8,4,5,6,123,9,8,999,454};

        long beginWork = System.currentTimeMillis();
        //创建两个线程，并启动
        Thread t1 = new Thread(new ThreadTest(nums, 0, nums.length/2));
        Thread t2 = new Thread(new ThreadTest(nums, nums.length/2, nums.length-1));

        //启动两个查找子线程
        t1.start();
        t2.start();

        //主线程等待两个查找子线程结束 
        t1.join();
        t2.join();

        long endWork = System.currentTimeMillis();

        System.out.println("WriteTime is " + (endWrite - beginWrite));

        System.out.println("ReadTime is " + (endRead - beginRead));

        System.out.println("WorkTime is " + (endWork - beginWork));

        //输出结果
        System.out.println("The min is " + ThreadTest.min);
        System.out.println("The max is "+ThreadTest.max);
    }
}


