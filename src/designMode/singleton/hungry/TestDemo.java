package designMode.singleton.hungry;

/**
 * Created by chunchen.meng on 2019/6/21.
 * https://mp.weixin.qq.com/s?__biz=MzI4Njg5MDA5NA==&mid=2247484239&idx=1&sn=6560be96e456b513cb1e4f78a740a258&chksm=ebd7424edca0cb584906fb97679cf2ca557f430fbc87d2c86ce0652d2e3c36c2528466942df5&scene=21#wechat_redirect
 */
public class TestDemo {

    public static void main(String[] args) {

        // 线程A
        new Thread(() -> {

            // 创建单例对象
            Java3y java3y = Java3y.getJava3y();
            System.out.println(java3y);

        }).start();

        // 线程B
        new Thread(() -> {
            // 创建单例对象
            Java3y java3y = Java3y.getJava3y();
            System.out.println(java3y);
        }).start();

        // 线程C
        new Thread(() -> {
            // 创建单例对象
            Java3y java3y = Java3y.getJava3y();
            System.out.println(java3y);
        }).start();

    }
}
