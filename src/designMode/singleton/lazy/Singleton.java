package designMode.singleton.lazy;

/**
 * Created by chunchen.meng on 2019/6/21.
 *
 * 静态内部类形式，既实现了线程安全，又避免了同步带来的性能影响 (推荐)
 */
public class Singleton {

    private Singleton (){
        System.out.println("init");

    }

    /** 使用静态内部类的方式来实现懒加载
        相当于其外部类的static成员，它的对象与外部类对象间不存在依赖关系，相互独立，因此可直接创建。
        在第一次被使用的时候才被会装载！！！！ ->初始化静态数据时，Java提供了的线程安全性保证。(所以不需要任何的同步)
     **/
    private static class LazyHolder {
        // 创建单例对象
        private static final Singleton INSTANCE = new Singleton();
    }

    // 获取对象
    public static final Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("main");
        Singleton singleton = getInstance();
    }
}
