package designMode.atguigu.facade;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//直接调用。。。很麻烦
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
		homeTheaterFacade.ready();
		homeTheaterFacade.play();
		
		
		homeTheaterFacade.end();
	}

}
