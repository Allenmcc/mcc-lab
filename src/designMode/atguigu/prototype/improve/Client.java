package designMode.atguigu.prototype.improve;



public class Client {

	public static void main(String[] args) {
		System.out.println("原型模式完成对象的创建");
		// 加个属性改动很方便，不用每个客户端都要改
		Sheep sheep = new Sheep("tom", 1, "白色");
		
		sheep.friend = new Sheep("jack", 2, "黑色");
		
		Sheep sheep2 = (Sheep)sheep.clone(); //克隆  浅拷贝,对象传递引用
		Sheep sheep3 = (Sheep)sheep.clone(); //克隆
		Sheep sheep4 = (Sheep)sheep.clone(); //克隆
		Sheep sheep5 = (Sheep)sheep.clone(); //克隆
		
		System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
		System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
		System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend.hashCode());
		System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend.hashCode());

		System.out.println(sheep.hashCode());
		System.out.println(sheep2.hashCode());
		System.out.println(sheep3.hashCode());
		System.out.println(sheep4.hashCode());
		System.out.println(sheep5.hashCode());

	}

}
