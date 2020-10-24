package designMode.atguigu.builder.improve;


// 抽象的建造者,产品对象的生产过程
public abstract class HouseBuilder {

//	组合,不能分离
	//产品本身的创建过程
	protected House house = new House();
	
	//将建造的流程写好，抽象的方法
	public abstract void buildBasic();
	public abstract void buildWalls();
	public abstract void roofed();
	
	//建造房好，将产品（房子）返回
	public House buildHouse() {
		return house;
	}
	
}
