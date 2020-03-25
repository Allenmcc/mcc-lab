package designMode.atguigu.factory.simplefactory.pizzastore.order;

import designMode.atguigu.factory.simplefactory.pizzastore.pizza.CheesePizza;
import designMode.atguigu.factory.simplefactory.pizzastore.pizza.GreekPizza;
import designMode.atguigu.factory.simplefactory.pizzastore.pizza.PepperPizza;
import designMode.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

//�򵥹�����
public class SimpleFactory {

	//����orderType ���ض�Ӧ��Pizza ����
	public Pizza createPizza(String orderType) {

		Pizza pizza = null;

		System.out.println("ʹ�ü򵥹���ģʽ");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" ϣ������ ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(" �������� ");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("��������");
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
