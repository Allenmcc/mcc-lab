package designMode.atguigu.singleton.type2;

public class SingletonTest02 {

	public static void main(String[] args) {
		//����
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
	}

}

//����ʽ(��̬����)

class Singleton {
	
	//1. ������˽�л�, �ⲿ��new
	private Singleton() {
		
	}
	

	//内部创建对象实例
	private  static Singleton instance;
	
	static { // 在静态代码块中，创建单例对象
		instance = new Singleton();
	}
	
	//3. 提供公有静态方法，返回实例对象
	public static Singleton getInstance() {
		return instance;
	}
	
}