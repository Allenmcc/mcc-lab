package designMode.atguigu.factory.absfactory.product;


//具体产品1：实现抽象产品中的抽象方法
//它同具体工厂之间一一对应
public class ConcreteProduct11 implements Product1{
    @Override
    public void show() {
        System.out.println("show具体产品1显示...");
    }
}
