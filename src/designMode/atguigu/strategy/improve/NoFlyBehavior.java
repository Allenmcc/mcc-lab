package designMode.atguigu.strategy.improve;

/**
 * 不会飞翔 的策略
 */
public class NoFlyBehavior implements FlyBehavior{

	@Override
	public void fly() {

		System.out.println(" 不会飞翔  ");
	}

}
