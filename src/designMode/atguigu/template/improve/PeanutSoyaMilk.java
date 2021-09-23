package designMode.atguigu.template.improve;

public class PeanutSoyaMilk extends SoyaMilk {

	@Override
	void addCondiments() {

		System.out.println(" 加入上好的花生 ");
	}

	@Override
	void soak() {
		System.out.println("第三步，子类重写， 黄豆和配料开始浸泡，需要3小时 ");
	}

}
