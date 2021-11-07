package designMode.atguigu.memento.theory;

/**
 * 发起人（Originator）角色：记录当前时刻的内部状态信息，
 * 提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，
 * 它可以访问备忘录里的所有信息。
 */
public class Originator {

	private String state;//状态信息

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//编写一个方法，可以保存一个状态对象Memento
	//因此编写一个方法，返回Memento  返回备忘录
	public Memento saveStateMemento() {
		return new Memento(state);
	}
	
	//通过备忘录对象，恢复状态
	public void getStateFromMemento(Memento memento) {
		state = memento.getState();
	}
}
