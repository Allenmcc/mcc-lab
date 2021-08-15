package designMode.atguigu.visitor;

public class Client {

	public static void main(String[] args) {

		//创建ObjectStructure
		ObjectStructure objectStructure = new ObjectStructure();
		//添加具体对象
		objectStructure.attach(new Man());
		objectStructure.attach(new Woman());

		System.out.println("=======给的是成功的测评========");
		//成功 具体元素
		Success success = new Success();
		//第一次分派
		objectStructure.display(success);
		
		System.out.println("=======给的是失败的测评========");
		//失败 具体元素
		Fail fail = new Fail();
		objectStructure.display(fail);
		
		System.out.println("=======给的是待定的测评========");

		//新添加的等待具体元素
		Wait wait = new Wait();
		objectStructure.display(wait);
	}

}
