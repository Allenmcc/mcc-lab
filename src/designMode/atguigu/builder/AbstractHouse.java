package designMode.atguigu.builder;

public abstract class AbstractHouse {
	
	//打地基
	public abstract void buildBasic();
	//砌墙
	public abstract void buildWalls();
	//封顶
	public abstract void roofed();


	//有顺序，放到一个方法里。 类似模板方法
	//接口就不能完成build
	public void build() {
		buildBasic();
		buildWalls();
		roofed();
	}
	
}
