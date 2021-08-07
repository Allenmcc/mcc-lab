package designMode.atguigu.factory.factorymethod.pizzastore.order;

import designMode.atguigu.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import designMode.atguigu.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import designMode.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * 北京工厂
 */
public class BJOrderPizzaFactoryFactory extends OrderPizzaFactory {

	
	@Override
	Pizza createPizza(String orderType) {
	
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new BJCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new BJPepperPizza();
		}
		return pizza;
	}

}
