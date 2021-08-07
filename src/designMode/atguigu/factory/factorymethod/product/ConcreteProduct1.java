package designMode.atguigu.factory.factorymethod.product;

//具体产品1：实现抽象产品中的抽象方法
//它同具体工厂之间一一对应
public class ConcreteProduct1 implements Product{
    @Override
    public void show() {
        System.out.println("show具体产品1显示...");
    }
}
