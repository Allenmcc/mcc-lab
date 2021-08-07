package designMode.atguigu.factory.factorymethod.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import designMode.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * 抽象工厂：提供了创建披萨的接口，
 * 调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 * 接口或者抽象类
 */
public abstract class OrderPizzaFactory {

	//定义一个抽象方法，createPizza，让各个工厂子类去实现
	abstract Pizza createPizza(String orderType);
	
	// 构造器
	public OrderPizzaFactory() {
		Pizza pizza = null;
		String orderType; // 订购pizza类型
		do {
			orderType = getType();
			pizza = createPizza(orderType); //抽象方法，由工厂子类完成
			//输出pizza 制作过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
			
		} while (true);
	}



	// 写一个方法,可以获取客户希望订购的披萨种类
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 种类:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
