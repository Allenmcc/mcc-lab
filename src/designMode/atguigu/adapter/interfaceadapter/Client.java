package designMode.atguigu.adapter.interfaceadapter;


//接口适配器
//适用于一个接口Interface4不想使用其所有方法的情况,只用m1()
public class Client {
	public static void main(String[] args) {

		//匿名内部类,new出来的东西本身就不是这个抽象类，而是他子类的实例.
		AbsAdapter absAdapter = new AbsAdapter() {
			//ֻ只需要取覆盖我们需要使用的接口方法,有选择的覆盖
			@Override
			public void m1() {
				System.out.println("使用m1的方法");
			}

		};


		//适用于一个接口Interface4不想使用其所有方法的情况,只用m1
		absAdapter.m1();

		//匿名内部类
		Interface4 interface4 = new AbsAdapter() {
		};
		interface4.m1();


	}
}
