package designMode.atguigu.factory.absfactory.pizzastore.order;

public class PizzaStore {

	public static void main(String[] args) {
		//简单工厂不能对多种实例（北京，伦敦的）的创建->抽象工厂
		//产品就几种类型，没有子类->简单工厂
		//new OrderPizza(new BJFactory());

		//使用还是OrderPizza
		new OrderPizza(new LDFactory());
	}

}
