package designMode.atguigu.strategy.improve;

public class Client {

	public static void main(String[] args) {
		WildDuck wildDuck = new WildDuck();
		wildDuck.fly();//默认策略 构造函数
		wildDuck.swim();//不变的部分
		
		ToyDuck toyDuck = new ToyDuck();
		toyDuck.fly(); //默认策略 构造函数
		toyDuck.swim();  //子类重写了
		
		PekingDuck pekingDuck = new PekingDuck();
		pekingDuck.fly(); //默认策略 构造函数
		pekingDuck.swim();//不变的部分
		
		//动态改变某个对象的行为，北京鸭不能飞 的策略  ，容易切换
		pekingDuck.setFlyBehavior(new NoFlyBehavior());
		System.out.println("北京鸭的实际飞翔能力");
		pekingDuck.fly();
	}

}
