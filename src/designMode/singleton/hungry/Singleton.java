package designMode.singleton.hungry;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public class Singleton {
    private Singleton() {
        System.out.println("init");
    }

    //静态变量，类加载时候初始化
    private static final Singleton single = new Singleton();

    public static Singleton getInstance() {
        return single;
    }

    public static void main(String[] args) {
        System.out.println("main");
        Singleton singleton = getInstance();
    }
}
