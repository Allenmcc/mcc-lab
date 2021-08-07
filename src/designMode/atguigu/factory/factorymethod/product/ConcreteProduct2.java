package designMode.atguigu.factory.factorymethod.product;

//具体产品2：实现抽象产品中的抽象方法
public class ConcreteProduct2 implements Product{
    @Override
    public void show() {
        System.out.println("show具体产品2显示...");
    }
}
