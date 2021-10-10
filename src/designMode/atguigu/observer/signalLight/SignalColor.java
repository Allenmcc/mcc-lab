package designMode.atguigu.observer.signalLight;


import java.util.EventObject;

/**
 * Created by allen
 */
//信号灯颜色  事件类
//event object :事件状态对象,用于listener的相应的方法之中，作为参数，一般存在与listerner的方法之中
// 继承EventObject
public class SignalColor extends EventObject {

    private String color; //"红色"和"绿色"

    public SignalColor(Object source, String color) {
        super(source);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
