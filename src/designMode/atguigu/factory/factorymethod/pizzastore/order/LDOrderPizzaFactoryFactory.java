package designMode.atguigu.factory.factorymethod.pizzastore.order;

import designMode.atguigu.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import designMode.atguigu.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import designMode.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * 伦敦工厂
 */
public class LDOrderPizzaFactoryFactory extends OrderPizzaFactory {

	
	@Override
	Pizza createPizza(String orderType) {
	
		Pizza pizza = null;
		if(orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;
	}

}
