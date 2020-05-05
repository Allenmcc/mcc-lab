package designMode.atguigu.flyweight;

import java.util.HashMap;

//网站工厂类，根据需要返回一个网站,一般只依赖内部状态，不依赖外部状态
public class WebSiteFactory {

	
	//集合，充当池的作用
	private HashMap<String, ConcreteWebSite> pool = new HashMap<>();
	
	//根据网站需要的类型，返回一个网站，如果没有就创建一个网站
	//并放入池中，并返回
	public WebSite getWebSiteCategory(String type) {
		if(!pool.containsKey(type)) {
			//就创建一个网站，并放入池中
			pool.put(type, new ConcreteWebSite(type));
		}
		
		return (WebSite)pool.get(type);
	}
	
	//获取网站分类的总数（池中有多少个网站）
	public int getWebSiteCount() {
		return pool.size();
	}
}