package designMode.atguigu.builder.improve;

public class Client {
	public static void main(String[] args) {

		//新增otherHouse无需修改原来的类库的代码，符合开闭

		//盖普通房子
		CommonHouse commonHouse = new CommonHouse();
		//准备创建房子的指挥着
		HouseDirector houseDirector = new HouseDirector(commonHouse);
		
		//完成盖房子，返回产品（房子）
		House house = houseDirector.constructHouse();
		
		//System.out.println("输出流程");
		
		System.out.println("--------------------------");
		//盖高楼
		HighBuilding highBuilding = new HighBuilding();
		//重置建造者
		houseDirector.setHouseBuilder(highBuilding);
		//完成盖房子，返回产品（房子）
		houseDirector.constructHouse();


		
		
	}
}
