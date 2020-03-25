package designMode.atguigu.principle.ocp.improve;

public class Ocp {

	public static void main(String[] args) {
		//ʹ�ÿ������ڵ�����
		GraphicEditor graphicEditor = new GraphicEditor();
		graphicEditor.drawShape(new Rectangle());
		graphicEditor.drawShape(new Circle());
		graphicEditor.drawShape(new Triangle());
		graphicEditor.drawShape(new OtherGraphic());
	}

}

//使用方，新增一个绘图类型，使用方不用改。
class GraphicEditor {
	//����Shape���󣬵���draw����
	public void drawShape(Shape s) {
		s.draw();
	}

	
}

//Shape 基类
abstract class Shape {
	int m_type;
	
	public abstract void draw();//抽象方法
}

class Rectangle extends Shape {
	Rectangle() {
		super.m_type = 1;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" 绘制其他图形 ");
	}
}

class Circle extends Shape {
	Circle() {
		super.m_type = 2;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" ����Բ�� ");
	}
}

//������������
class Triangle extends Shape {
	Triangle() {
		super.m_type = 3;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" ���������� ");
	}
}

//����һ��ͼ��
class OtherGraphic extends Shape {
	OtherGraphic() {
		super.m_type = 4;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" ��������ͼ�� ");
	}
}
