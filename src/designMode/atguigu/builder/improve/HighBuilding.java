package designMode.atguigu.builder.improve;

//具体建造者-高楼
public class HighBuilding extends HouseBuilder {

	@Override
	public void buildBasic() {
		house.setBaise("高楼打地基100米");
		System.out.println(" 高楼打地基100米 ");
	}

	@Override
	public void buildWalls() {
		house.setWall("高楼砌墙20cm");
		System.out.println(" 高楼砌墙20cm ");
	}

	@Override
	public void roofed() {
		house.setRoofed("高楼透明屋顶");
		System.out.println(" 高楼透明屋顶 ");
	}

}
