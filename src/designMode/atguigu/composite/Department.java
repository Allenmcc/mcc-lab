package designMode.atguigu.composite;

public class Department extends OrganizationComponent {

	//没有集合

	//构造器
	public Department(String name, String des) {
		super(name, des);
	}

	
	//add , remove 就不用写了，叶子节点不用管理其他单位
	
	@Override
	public String getName() {

		return super.getName();
	}
	
	@Override
	public String getDes() {

		return super.getDes();
	}
	
	@Override
	protected void print() {

		System.out.println(getName());
	}

}
