package designMode.atguigu.visitor;

/**
 * 抽象元素（Element）角色：声明包含接受操作的接口，
 * 被接受的访问者对象作为方法的 getManResult getWomanResult 方法的参数。
 */
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
