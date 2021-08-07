package designMode.atguigu.builder.improve;

//具体建造者-普通房子
public class CommonHouse extends HouseBuilder {

	//制造流程和产品本身（house 的属性）解耦
	@Override
	public void buildBasic() {
		house.setBaise("普通房子打地基5米");
		System.out.println(" 普通房子打地基5米 ");
	}

	@Override
	public void buildWalls() {
		house.setWall("普通房子砌墙10里米");
		System.out.println(" 普通房子砌墙10里米 ");
	}

	@Override
	public void roofed() {
		house.setRoofed("普通房子屋顶");
		System.out.println(" 普通房子屋顶 ");
	}

}
