package designMode.atguigu.decorator;

public class Milk extends Decorator {

	public Milk(Drink obj) {
		//父类装饰类构造器,需要初始化父类里面主体
		super(obj);
		// TODO Auto-generated constructor stub
		setDes(" 牛奶 ");
		setPrice(2.0f); 
	}

}
