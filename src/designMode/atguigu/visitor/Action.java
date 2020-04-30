package designMode.atguigu.visitor;

public abstract class Action {

	/**
	 * 稳定的数据结构
	 * @param man
	 */


	//得到男性的测评
	public abstract void getManResult(Man man);
	
	//得到女性的测评
	public abstract void getWomanResult(Woman woman);
}
