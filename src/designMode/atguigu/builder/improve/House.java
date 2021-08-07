package designMode.atguigu.builder.improve;

//Product本身
public class House {
	private String baise;
	private String wall;
	private String roofed;
	public String getBaise() {
		return baise;
	}
	public void setBaise(String baise) {
		this.baise = baise;
	}
	public String getWall() {
		return wall;
	}

	public void setWall(String wall) {
		this.wall = wall;
	}

	public String getRoofed() {
		return roofed;
	}

	public void setRoofed(String roofed) {
		this.roofed = roofed;
	}

	public void show(){
		//显示产品特性
		System.out.println("House show 一下 baise :"+baise);
	}
	
}
