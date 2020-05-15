package designMode.atguigu.adapter.classadapter;

//adapter wrapper 把底层Service 包装一下给其他类调用
public class Client {

	public static void main(String[] args) {

		System.out.println(" === 类适配器模式 ====");
		Phone phone = new Phone();
		phone.charging(new VoltageAdapter());  //具体实现
	}

}
