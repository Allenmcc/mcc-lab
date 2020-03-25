package designMode.atguigu.adapter.objectadapter;

//被适配的类
public class Voltage220V {
	//输出220v电压
	public int output220V() {
		int src = 220;
		System.out.println("电压=" + src + "v");
		return src;
	}
}
