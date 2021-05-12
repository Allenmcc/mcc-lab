package designMode.atguigu.strategy.improve;

/**
 * 类Context 提供策略模式接口
 */
public abstract class Duck {

	//属性，策略接口 提供设置飞行策略的方式
	FlyBehavior flyBehavior;
	//其他属性<->策略接口  提供设置叫策略的方式
	QuackBehavior quackBehavior;
	
	public Duck() {
	
	}


	public abstract void display();//显示鸭子信息，一定要子类实现的

	//不变的部分 ，子类可以重新
	public void quack() {
		System.out.println("鸭子嘎嘎叫");
	}
	//不变的部分 ，子类可以重新
	public void swim() {
		System.out.println("鸭子会游泳");
	}

	//变化部分   设置策略 针对接口编程，而不是具体类
	public void fly() {
		//改进
		if(flyBehavior != null) {
			flyBehavior.fly();
		}
	}

	//提供改行为的方法  策略
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	
	
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	
	
}
