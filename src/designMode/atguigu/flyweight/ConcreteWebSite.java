package designMode.atguigu.flyweight;

/**
 * 具体享元（Concrete Flyweight）角色：实现抽象享元角色中所规定的接口。
 */
//具体的网站
public class ConcreteWebSite extends WebSite {

	//共享的部分，内部状态
	private String type = ""; //网站发布的形式（类型）

	
	//构造器
	public ConcreteWebSite(String type) {
		
		this.type = type;
	}


	/**
	 * User非享元（Unsharable Flyweight)角色：是不可以共享的外部状态，
	 * 它以参数的形式注入具体享元的相关方法中。
	 * @param user
	 */
	@Override
	public void use(User user) {

		System.out.println("网站的发布形式为:" + type + " 在使用中，使用者是" + user.getName());
	}
	
	
}
