package designMode.atguigu.strategy.improve;

public class ToyDuck extends Duck{

	
	public ToyDuck() {
		flyBehavior = new NoFlyBehavior();
	}
	
	@Override
	public void display() {
		System.out.println("玩具鸭");
	}

	//不变的部分 可以重写父类的方法，也可以不重写
	
	public void quack() {
		System.out.println("toy鸭叫~~");
	}
	
	public void swim() {
		System.out.println("toy鸭游泳");
	}
	
	
}
