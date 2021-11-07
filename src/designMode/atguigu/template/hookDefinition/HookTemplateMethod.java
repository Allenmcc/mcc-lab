package designMode.atguigu.template.hookDefinition;

/**
 * Created by allen
 */
public class HookTemplateMethod {

    public static void main(String[] args) {
        HookAbstractClass tm = new HookConcreteClass();
        tm.TemplateMethod();
    }
}
