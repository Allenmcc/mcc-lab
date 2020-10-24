package designMode.atguigu.factory.absfactory.pizzastore.order;


import designMode.atguigu.factory.absfactory.pizzastore.pizza.LDCheesePizza;
import designMode.atguigu.factory.absfactory.pizzastore.pizza.LDPepperPizza;
import designMode.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * 抽象工厂模式把产品子类进行分组，同组中的不同产品由同一个工厂子类的不同方法负责创建，
 * 从而减少了工厂子类的数量。
 */
public class LDFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~使用抽象工厂模式~");
		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			// 依赖 组合
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;
	}

}
