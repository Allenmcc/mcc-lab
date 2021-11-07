package designMode.atguigu.builder.definition;

/**
 * Created by allen
 */
//http://c.biancheng.net/view/1354.html
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
