package designMode.atguigu.decorator.theory;


/**
 * Created by allen
 */
//具体装饰角色
//具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();   //具体产品的操作
        addedFunction();     //装饰器而外操作
    }

    public void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}
