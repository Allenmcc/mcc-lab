package designMode.atguigu.singleton.type7;

/**
 * 静态内部类
 * https://www.cnblogs.com/shenwen/p/10707965.html
 * https://blog.csdn.net/mnb65482/article/details/80458571
 */

public class SingletonTest07 {

	public static void main(String[] args) {
		System.out.println("使用静态内部类完成单例模式");
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
		
	}

}

// 静态内部类完成，推荐使用
class Singleton {
	//volatile 轻量级synchronized
	private static volatile Singleton instance;
	
	//构造器私有化
	private Singleton() {}
	
	//写一个静态内部类，该类中有一个静态属性 Singleton

	//优点：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
	// 即当SingleTon第一次被加载时，并不需要去加载SingletonInstance，只有当getInstance()方法第一次被调用时，
	// 才会去初始化INSTANCE,第一次调用getInstance()方法会导致虚拟机加载SingletonInstance类，
	// 这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton(); 
	}
	
	//提供一个静态的公有方法，直接返回SingletonInstance.INSTANCE
	//利用jvm底层类装载机制，保证线程安全
	//how?
	//虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，
	// 那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
	// 如果在一个类的<clinit>()方法中有耗时很长的操作，就可能造成多个进程阻塞(需要注意的是，其他线程虽然会被阻塞，
	// 但如果执行<clinit>()方法后，其他线程唤醒之后不会再次进入<clinit>()方法。同一个加载器下，一个类型只会初始化一次。)，
	// 在实际应用中，这种阻塞往往是很隐蔽的。
	//故而，可以看出INSTANCE在创建过程中是线程安全的，所以说静态内部类形式的单例可保证线程安全，也能保证单例的唯一性，
	// 同时也延迟了单例的实例化。

	public static  Singleton getInstance() {
		
		return SingletonInstance.INSTANCE;
	}
}