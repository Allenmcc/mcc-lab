package designMode.atguigu.visitor;

/**
 * 具体元素（ConcreteElement）角色：实现抽象元素角色提供的  操作，
 * 其方法体通常都是，另外具体元素中可能还包含本身业务逻辑的相关操作。
 */
public class Success extends Action {

	@Override
	public void getManResult(Man man) {

		System.out.println(" 男人给的评价是该歌手很成功!");
	}

	@Override
	public void getWomanResult(Woman woman) {

		System.out.println(" 女人给的评价是该歌手很成功!");
	}

}
