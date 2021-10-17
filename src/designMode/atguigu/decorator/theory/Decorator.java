package designMode.atguigu.decorator.theory;

/**
 * Created by allen
 */

//抽象装饰角色
//抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
public class Decorator implements Component {
    private Component component;  //主体,被装饰者  聚合

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

}
