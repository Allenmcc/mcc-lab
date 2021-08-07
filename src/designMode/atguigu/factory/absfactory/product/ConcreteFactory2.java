package designMode.atguigu.factory.absfactory.product;

//具体工厂2：实现了厂品的生成方法
public class ConcreteFactory2 implements AbstractFactory {


    @Override
    public Product1 newProduct1() {
        System.out.println("具体工厂2  生成-->具体产品 11...");
        return new ConcreteProduct11();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("具体工厂2 生成-->具体产品 21...");
        return new ConcreteProduct21();
    }
}
