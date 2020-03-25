package designMode.atguigu.adapter.interfaceadapter;

public class Client {
	public static void main(String[] args) {

		//匿名内部类
		AbsAdapter absAdapter = new AbsAdapter() {
			//ֻ只需要取覆盖我们需要使用的接口方法
			@Override
			public void m1() {
				// TODO Auto-generated method stub
				System.out.println("使用m1的方法");
			}

		};
		
		absAdapter.m1();
	}
}
