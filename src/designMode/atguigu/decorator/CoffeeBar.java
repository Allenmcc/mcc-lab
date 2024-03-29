package designMode.atguigu.decorator;

public class CoffeeBar {

	public static void main(String[] args) {
		// 装饰者模式下的订单：2份巧克力+一份牛奶的LongBlack

		// 1. 点一份 LongBlack，不用LongBlack longBlack，还没有点完
		Drink order = new LongBlack();
		System.out.println("费用1=" + order.cost());
		System.out.println("描述=" + order.getDes());

		// 2. order 加入一份牛奶,装饰一下
		// 动态的将新功能附加到对象上,开闭原则(OCP)
		order = new Milk(order);

		//cost  算总价
		System.out.println("order 加入一份牛奶 费用 = " + order.cost());
		//price 单品价格
		System.out.println("order 加入一份牛奶 费用 getPrice = " + order.getPrice());
		System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

		// 3. order 加入一份巧克力
		// 动态的将新功能附加到对象上，obj （LongBlack+一份牛奶）
		order = new Chocolate(order);

		System.out.println("order 加入一份牛奶 加入一份巧克力 费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 加入一份巧克力 费用 getPrice =" + order.getPrice());
		System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = " + order.getDes());

		// 4. order 加入一份巧克力
		// 动态的将新功能附加到对象上，obj （LongBlack+一份牛奶+一份巧克力）
		order = new Chocolate(order);

		System.out.println("order 加入一份牛奶 加入2份巧克力 费用 =" + order.cost());
		System.out.println("order 加入一份牛奶 加入2份巧克力 描述 = " + order.getDes());
	
		System.out.println("===========================");
		
		Drink order2 = new DeCaf();
		
		System.out.println("order2 无因咖啡 费用 =" + order2.cost());
		System.out.println("order2 无因咖啡 描述 = " + order2.getDes());
		
		order2 = new Milk(order2);
		
		System.out.println("order2 无因咖啡 加入一份牛奶 费用 =" + order2.cost());
		System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());

	
	}

}
