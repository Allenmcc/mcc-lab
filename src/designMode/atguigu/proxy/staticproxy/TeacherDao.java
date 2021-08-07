package designMode.atguigu.proxy.staticproxy;

public class TeacherDao implements ITeacherDao {

	@Override
	public void teach() {

		System.out.println(" （目标对象）老师授课中");
	}

}
