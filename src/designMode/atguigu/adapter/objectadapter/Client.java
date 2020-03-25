package designMode.atguigu.adapter.objectadapter;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" === 对象适配器 ====");
		Phone phone = new Phone();
		//继承->聚合 要传入对象
		phone.charging(new VoltageAdapter(new Voltage220V()));
	}

}
