package designMode.atguigu.decorator;

//缓冲层,将具体产品的公共部分提取出来,抽象层一个类
public class Coffee  extends Drink {

	//公共部分,获得改产品费用
	@Override
	public float cost() {

		return super.getPrice();
	}

	
}
