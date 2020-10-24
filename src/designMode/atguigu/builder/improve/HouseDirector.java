package designMode.atguigu.builder.improve;

//基于抽象类建造房屋
//构建一个使用Builder接口的对象.主要作用是创建一个复杂的对象.主要作用1.隔离客户与对象的生产过程2.负责控制产品对象的生产过程
public class HouseDirector {
	
	HouseBuilder houseBuilder = null;

	//构造器 houseBuilder
	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	//通过setter方法 传入 houseBuilder
	public void setHouseBuilder(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}
	
	//如何处理建造房子的流程，交给指挥者
	public House constructHouse() {
		houseBuilder.buildBasic();
		houseBuilder.buildWalls();
		houseBuilder.roofed();
		return houseBuilder.buildHouse();
	}
	
	
}
