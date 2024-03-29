package designMode.atguigu.flyweight;

public class Client {

	public static void main(String[] args) {


		// 创建一个工厂类
		WebSiteFactory factory = new WebSiteFactory();

		// 客户要一个新闻形式发布的网站
		WebSite webSite1 = factory.getWebSiteCategory("新闻");

		//是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中。
		webSite1.use(new User("tom"));

		// 客户要一个博客形式发布的网站
		WebSite webSite2 = factory.getWebSiteCategory("博客");

		webSite2.use(new User("jack"));

		// 客户要一个博客形式发布的网站
		WebSite webSite3 = factory.getWebSiteCategory("博客");

		webSite3.use(new User("smith"));

		// 客户要一个博客形式发布的网站
		WebSite webSite4 = factory.getWebSiteCategory("博客");

		webSite4.use(new User("king"));
		
		System.out.println("网站的发布形式为=" + factory.getWebSiteCount());
	}

}
