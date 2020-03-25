package designMode.atguigu.adapter.classadapter;

public class Phone {

	//充电 手机依赖IVoltage5V，实际传的是VoltageAdapter
	public void charging(IVoltage5V iVoltage5V) {
		if(iVoltage5V.output5V() == 5) {
			System.out.println("电压5v，可以充电~~");
		} else if (iVoltage5V.output5V() > 5) {
			System.out.println("电压大于5v，无法充电~~");
		}
	}
}
