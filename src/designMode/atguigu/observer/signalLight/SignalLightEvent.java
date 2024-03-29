package designMode.atguigu.observer.signalLight;

/**
 * Created by allen
 */
//行为型

// java中的事件机制的参与者有3种角色
// 1.event object：事件状态对象，用于listener的相应的方法之中，作为参数，一般存在与listerner的方法之中
// 2.event listener：对每个明确的事件的发生，都相应地定义一个明确的Java方法。这些方法都集中定义在事件监听者（EventListener）接口中，
// 这个接口要继承 java.util.EventListener。 实现了事件监听者接口中一些或全部方法的类就是事件监听者。
// 3.event source：具体的事件源，比如说，你点击一个button，那么button就是event source，要想使button对某些事件进行响应，你就需要注册特定的listener。
public class SignalLightEvent {

    public static void main(String[] args) {
        SignalLight light = new SignalLight();//交通信号灯（事件源）
        light.addVehicleListener(new Car());  //注册监听器（轿车 观察者）
        light.addVehicleListener(new Buses());//注册监听器（公交车 观察者）
        light.changeColor("红色");
        System.out.println("------------");
        light.changeColor("绿色");
    }
}
