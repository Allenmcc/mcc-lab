package designMode.atguigu.visitor;

public class Man extends Person {

	@Override
	public void accept(Action action) {
		// 本身测传递过去
		action.getManResult(this);
	}

}
