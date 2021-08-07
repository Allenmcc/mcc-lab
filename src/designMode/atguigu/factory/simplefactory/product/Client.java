package designMode.atguigu.factory.simplefactory.product;

public class Client {
    public static void main(String[] args) {
        Product product =  SimpleFactory.makeProduct(0);
        product.show();
    }

    //抽象产品 产品多个动作并且有序可以看OrderPizza ->setFactory
    public interface Product {
        void show();
    }

    //具体产品：ProductA
    static class ConcreteProduct1 implements Product {
        @Override
        public void show() {
            System.out.println("具体产品1显示...");
        }
    }

    //具体产品：ProductB
    static class ConcreteProduct2 implements Product {
        @Override
        public void show() {
            System.out.println("具体产品2显示...");
        }
    }

    final class Const {
        static final int PRODUCT_A = 1;
        static final int PRODUCT_B = 2;
        static final int PRODUCT_C = 3;
    }

    static class SimpleFactory {
        //又是静态工厂
        public static Product makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT_A:
                    return new ConcreteProduct1();
                case Const.PRODUCT_B:
                    return new ConcreteProduct2();
            }
            return null;
        }
    }
}
