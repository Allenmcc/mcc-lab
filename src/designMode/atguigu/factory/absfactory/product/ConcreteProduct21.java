package designMode.atguigu.factory.absfactory.product;


//具体产品2：实现抽象产品中的抽象方法
public class ConcreteProduct21 implements Product2{
    @Override
    public void show() {
        System.out.println("show具体产品2显示...");
    }
}
