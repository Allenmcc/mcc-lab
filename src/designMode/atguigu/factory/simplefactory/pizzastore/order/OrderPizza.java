package designMode.atguigu.factory.simplefactory.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import designMode.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

public class OrderPizza {

	// ������
//	public OrderPizza() {
//		Pizza pizza = null;
//		String orderType; // ��������������
//		do {
//			orderType = getType();
//			if (orderType.equals("greek")) {
//				pizza = new GreekPizza();
//				pizza.setName(" ϣ������ ");
//			} else if (orderType.equals("cheese")) {
//				pizza = new CheesePizza();
//				pizza.setName(" �������� ");
//			} else if (orderType.equals("pepper")) {
//				pizza = new PepperPizza();
//				pizza.setName("��������");
//			} else {
//				break;
//			}
//			//���pizza ��������
//			pizza.prepare();
//			pizza.bake();
//			pizza.cut();
//			pizza.box();
//			
//		} while (true);
//	}

	//定义简单工厂对象
	SimpleFactory simpleFactory;
	Pizza pizza = null;
	
	//构造器，聚合
	public OrderPizza(SimpleFactory simpleFactory) {
		setFactory(simpleFactory);
	}
	
	public void setFactory(SimpleFactory simpleFactory) {
		String orderType = ""; //用户输入
		
		this.simpleFactory = simpleFactory; //设置简单工厂对象
		
		do {
			orderType = getType(); 
			pizza = this.simpleFactory.createPizza(orderType);
			
			//输出pizza
			if(pizza != null) { //订购成功
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println(" 订购pizza失败 ");
				break;
			}
		}while(true);
	}
	
	// дһ�����������Ի�ȡ�ͻ�ϣ����������������
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza ����:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
