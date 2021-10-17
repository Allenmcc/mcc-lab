package designMode.atguigu.decorator;

//包装, 具体的Decorator，这里就是调味品
//具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
public class Milk extends Decorator {

	public Milk(Drink obj) {
		//父类装饰类构造器,需要初始化父类里面主体
		super(obj);  //传递对象，父类装饰器初始化
		setDes(" 牛奶 ");
		setPrice(2.0f); 
	}

}
