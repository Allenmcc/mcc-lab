package designMode.atguigu.state.define;

public class ConcreteStateB extends State {

    @Override
    public void Handle(Context context) {
        System.out.println("当前状态是 B.");
        //状态的传递
        context.setState(new ConcreteStateA());
    }
}
