package designMode.atguigu.factory.absfactory.pizzastore.order;

import designMode.atguigu.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import designMode.atguigu.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import designMode.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

//工厂子类
public class BJFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("~使用抽象工厂模式~");

		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")){
			pizza = new BJPepperPizza();
		}
		return pizza;
	}

}
