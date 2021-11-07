package designMode.atguigu.template.definition;


/**
 * Created by allen
 * 模板方法（行为型），有点像建造者（创建型）
 */
//http://c.biancheng.net/view/1376.html
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.TemplateMethod();
    }
}
