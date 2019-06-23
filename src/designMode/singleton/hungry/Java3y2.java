package designMode.singleton.hungry;

/**
 * Created by chunchen.meng on 2019/6/21.
 * 在单线程环境下是行的，在多线程环境下就不行了！
 */
public class Java3y2 {
    // 1.将构造函数私有化，不可以通过new的方式来创建对象
    private Java3y2(){}

    // 2.1先不创建对象，等用到的时候再创建
    private static volatile Java3y2 java3y = null;

    // 2.1调用到这个方法了，证明是要被用到的了
    public static Java3y2 getJava3y() {

        //加锁保证多线程环境下没有问题，但是性能比较低，所有将锁的方法缩小。
//    public static synchronized Java3y getJava3y() {

        // 3. 如果这个对象引用为null，我们就创建并返回出去
        //判null主要为了提高性能
        if (java3y == null) {

            synchronized (Java3y2.class) {

                //再判断一次是否为null
                if(java3y == null) {
                    java3y = new Java3y2();
                }
            }
        }

        return java3y;
    }


    public static void main(String[] args) {

        // 线程A
        new Thread(() -> {

            // 创建单例对象
            Java3y2 java3y = Java3y2.getJava3y();
            System.out.println(java3y);

        }).start();

        // 线程B
        new Thread(() -> {
            // 创建单例对象
            Java3y2 java3y = Java3y2.getJava3y();
            System.out.println(java3y);
        }).start();

        // 线程C
        new Thread(() -> {
            // 创建单例对象
            Java3y2 java3y = Java3y2.getJava3y();
            System.out.println(java3y);
        }).start();

    }

}
