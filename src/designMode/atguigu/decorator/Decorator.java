package designMode.atguigu.decorator;

public class Decorator extends Drink {
	private Drink obj;  //被装饰者
	
	public Decorator(Drink obj) { //构造器 组合关系
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}
	
	@Override
	public float cost() {
		// TODO Auto-generated method stub
		// getPrice 自己的价格
		return super.getPrice() + obj.cost();
	}
	
	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		// obj.getDes() 输出被装饰者信息
		return des + " " + getPrice() + " && " + obj.getDes();
	}
	
	

}
