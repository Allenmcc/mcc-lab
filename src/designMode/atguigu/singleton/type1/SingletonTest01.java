package designMode.atguigu.singleton.type1;

public class SingletonTest01 {

	public static void main(String[] args) {
		//测试
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
		System.out.println(instance.use());
		System.out.println(instance2.use());
	}

}

//饿汉式（静态常量） 推荐
class Singleton {
	
	//1. 构造器私有化，外部能new
	private Singleton() {
		
	}

	//2.本类内部创建实例对象
	//优点:类装载时候完成实例化,避免线程同步问题.
	//缺点:类装载时候完成实例化,如果从始至终未使用这个实例,则会造成内存浪费.
	private final static Singleton instance = new Singleton();

	//3.提供一个公有的静态方法，返回实例对象
	public static Singleton getInstance() {
		return instance;
	}

	//使用单例
	public long use() {
		return System.currentTimeMillis();
	}
	
}