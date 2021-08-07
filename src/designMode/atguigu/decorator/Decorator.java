package designMode.atguigu.decorator;

//装饰类
public class Decorator extends Drink {
	private Drink obj;  //主体,被装饰者  继承+聚合
	
	public Decorator(Drink obj) { //构造器 组合关系
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	//费用:包装产品价格+主题产品费用
	@Override
	public float cost() {

		// getPrice 自己的价格
		return super.getPrice() + obj.cost();
	}
	
	@Override
	public String getDes() {

		// obj.getDes() 输出被装饰者信息
		return des + " " + getPrice() + " && " + obj.getDes();
	}
	
	

}
