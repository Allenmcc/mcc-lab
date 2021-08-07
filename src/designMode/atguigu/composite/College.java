package designMode.atguigu.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

	//List存放Department  OrganizationComponent作为属性组合到College
	List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

	// 构造器
	public College(String name, String des) {
		super(name, des);
		// TODO Auto-generated constructor stub
	}

	// 重写add
	@Override
	protected void add(OrganizationComponent organizationComponent) {

		//  将来实际业务中Colleage 的add 和  University add 不一定完全一样
		organizationComponents.add(organizationComponent);
	}

	// 重写remove
	@Override
	protected void remove(OrganizationComponent organizationComponent) {

		organizationComponents.remove(organizationComponent);
	}

	@Override
	public String getName() {

		return super.getName();
	}

	@Override
	public String getDes() {

		return super.getDes();
	}

	// print�������������University ������ѧԺ
	@Override
	protected void print() {

		System.out.println("--------------" + getName() + "--------------");
		//���� organizationComponents 
		for (OrganizationComponent organizationComponent : organizationComponents) {
			organizationComponent.print();
		}
	}


}
