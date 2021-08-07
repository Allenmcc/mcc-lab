package designMode.atguigu.strategy;

//继承 实现抽象方法
public class PekingDuck extends Duck {

	@Override
	public void display() {

		System.out.println("~~北京鸭~~~");
	}
	
	//因为北京鸭不能飞行，因此需要重写fly
	@Override
	public void fly() {

		System.out.println("北京鸭不能飞翔");
	}

}
