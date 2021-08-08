package designMode.atguigu.state.define;

/**
 * 具体状态（Concrete State）角色：实现抽象状态所对应的行为，
 * 并且在需要的情况下进行状态切换。
 */
public class ConcreteStateA extends State {

    @Override
    public void Handle(Context context) {
        System.out.println("当前状态是 A.");
        //状态的传递
        context.setState(new ConcreteStateB());
    }
}
