package designMode.atguigu.composite;

public abstract class OrganizationComponent {

	private String name; // 名字
	private String des; // 描述

	//为啥不写抽象方法？ 如果抽象，子类都要实现，叶子Department不需要实现这个
	protected  void add(OrganizationComponent organizationComponent) {
		//默认实现
		throw new UnsupportedOperationException();
	}
	
	protected  void remove(OrganizationComponent organizationComponent) {
		//默认实现
		throw new UnsupportedOperationException();
	}

	//构造器
	public OrganizationComponent(String name, String des) {
		super();
		this.name = name;
		this.des = des;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	//打印方法，抽象，不管叶子非叶子都要实现
	protected abstract void print();
	
	
}
