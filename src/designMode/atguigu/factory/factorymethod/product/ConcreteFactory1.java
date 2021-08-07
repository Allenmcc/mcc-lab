package designMode.atguigu.factory.factorymethod.product;

public class ConcreteFactory1 implements AbstractFactory {

    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        //它同具体工厂之间一一对应。
        return new ConcreteProduct1();
    }
}
