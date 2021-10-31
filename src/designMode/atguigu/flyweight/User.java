package designMode.atguigu.flyweight;

/**
 * 非享元（Unsharable Flyweight)角色：是不可以共享的外部状态，
 * 它以参数的形式注入具体享元的相关方法中。
 */
//外部状态
public class User {
	
	private String name;

	
	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
