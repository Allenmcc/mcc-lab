package designMode.atguigu.factory.simplefactory.pizzastore.order;

import designMode.atguigu.factory.simplefactory.pizzastore.pizza.CheesePizza;
import designMode.atguigu.factory.simplefactory.pizzastore.pizza.GreekPizza;
import designMode.atguigu.factory.simplefactory.pizzastore.pizza.PepperPizza;
import designMode.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

//简单工厂(静态工厂模式)
public class SimpleFactory {

	//
	public Pizza createPizza(String orderType) {

		Pizza pizza = null;

		System.out.println("订购披萨");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" 希腊披萨 ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(" 奶酪披萨 ");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("胡椒披萨");
		}
		
		return pizza;
	}
	
	//简单工厂模式也叫静态工厂模式
	public static Pizza createPizza2(String orderType) {

		Pizza pizza = null;

		System.out.println("使用简单工厂模式");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" 希腊披萨 ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(" 奶酪披萨 ");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("胡椒披萨");
		}
		
		return pizza;
	}

}
