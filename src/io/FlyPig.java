package io;

import java.io.Serializable;

/**
 * https://blog.csdn.net/u013870094/article/details/82765907
 */
public class FlyPig implements Serializable {

    //默认自动添加随机值(根据属性计算),最好手动添加固定值,因为手动添加固定值可以避免添加属性反序列化失败的场景.
//    private static final long serialVersionUID = 1L;

    //静态static的属性，不会被序列化
    private static String AGE = "26999";
    private String name;
    private String color;

    //transient 修饰的属性，是不会被序列化的。我设置的奥迪四个圈的车不见啦，成了null.
    transient private String car;

    private String addTip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getAddTip() {
        return addTip;
    }

    public void setAddTip(String addTip) {
        this.addTip = addTip;
    }

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE + '\'' +
                //", addTip='" + addTip + '\'' +
                '}';
    }
}
