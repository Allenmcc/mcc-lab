package designMode.atguigu.strategy.improve;

/**
 * 不会飞翔 的策略
 */
public class NoFlyBehavior implements FlyBehavior{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println(" 不会飞翔  ");
	}

}
