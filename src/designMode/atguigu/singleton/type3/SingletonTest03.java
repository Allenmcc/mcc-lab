package designMode.atguigu.singleton.type3;


public class SingletonTest03 {

	public static void main(String[] args) {
		System.out.println("懒汉式，线程不安全");
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
	}

}
//懒汉式，线程不安全
class Singleton {
	private static Singleton instance;
	
	private Singleton() {}
	
	//提供一个静态的公有方法，当使用到该方法时，才去创建instance
	//即懒汉式
	public static Singleton getInstance() {
		//多个线程执行这个,会产生多个实例,线程不安全
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}