package designMode.singleton.hungry;

/**
 * Created by chunchen.meng on 2019/6/21.
 * 在单线程环境下是行的，在多线程环境下就不行了！
 */
public class Java3y {
    // 1.将构造函数私有化，不可以通过new的方式来创建对象
    private Java3y(){}

    // 2.1先不创建对象，等用到的时候再创建
    private static Java3y java3y = null;

    // 2.1调用到这个方法了，证明是要被用到的了
    public static  Java3y getJava3y() {

        //加锁保证多线程环境下没有问题，但是性能比较低，所有将锁的方法缩小。
//    public static synchronized Java3y getJava3y() {

        // 3. 如果这个对象引用为null，我们就创建并返回出去
        if (java3y == null) {

            synchronized (Java3y.class) {
                java3y = new Java3y();
            }
        }

        return java3y;
    }

}
