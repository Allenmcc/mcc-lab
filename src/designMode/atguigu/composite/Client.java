package designMode.atguigu.composite;

public class Client {

	public static void main(String[] args) {

		
		//从大到小创建对象
		OrganizationComponent university = new University("清华大学", " 中国顶级大学 ");
		
		//创建学院
		OrganizationComponent computerCollege = new College("计算机学院", " 计算机学院 ");
		OrganizationComponent infoEngineercollege = new College("信息工程学院", " 信息工程学院 ");
		
		
		//创建各个学院下的系（专业）
		computerCollege.add(new Department("软件工程", " 软件工程不错 "));
		computerCollege.add(new Department("网络工程", " 网络工程不错 "));
		computerCollege.add(new Department("计算机科学与技术", " 计算机科学与技术是老牌专业 "));
		
		//
		infoEngineercollege.add(new Department("ͨ通信工程", " 通信工程不好学 "));
		infoEngineercollege.add(new Department("信息工程", " 信息工程不好学 "));
		
		//将学院添加到学校
		university.add(computerCollege);
		university.add(infoEngineercollege);
		
		university.print();
//		infoEngineercollege.print();
	}

}
