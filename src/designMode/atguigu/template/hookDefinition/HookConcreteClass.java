package designMode.atguigu.template.hookDefinition;


/**
 * Created by allen
 */
public class HookConcreteClass extends HookAbstractClass{

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }

    @Override
    public void HookMethod1() {
        System.out.println("钩子方法1被重写...");
    }

    //子类重写了
    @Override
    public boolean HookMethod2() {
        return false;
    }
}
