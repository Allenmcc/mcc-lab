package designMode.atguigu.observer.signalLight;

import java.util.EventListener;

/**
 * Created by allen
 */

//抽象观察者类：车
public interface Vehicle extends EventListener {

    //事件处理方法，看见
    public void see(SignalColor e);
}
