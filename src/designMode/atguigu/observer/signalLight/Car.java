package designMode.atguigu.observer.signalLight;


/**
 * Created by allen
 */

//具体观察者类：轿车   事件监听器&具体观察者
// 对每个明确的事件的发生，都相应地定义一个明确的Java方法。
// 这些方法都集中定义在事件监听者（EventListener）接口中，
//这个接口要继承 java.util.EventListener。 实现了事件监听者接口中一些或全部方法的类就是事件监听者。
public class Car implements Vehicle{

    public void see(SignalColor e) {
        if ("红色".equals(e.getColor())) {
            System.out.println("红灯亮，轿车停！");
        } else {
            System.out.println("绿灯亮，轿车行！");
        }
    }
}
