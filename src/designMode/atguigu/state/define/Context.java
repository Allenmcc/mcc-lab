package designMode.atguigu.state.define;

/**
 *
 * 环境类（Context）角色：也称为上下文，它定义了客户端需要的接口，
 * 内部维护一个当前状态，并负责具体状态的切换。
 */
public class Context {

    //内部维护一个当前状态，并负责具体状态的切换。
    private State state;

    //定义环境类的初始状态
    public Context() {
        this.state = new ConcreteStateA();
    }
    //设置新状态
    public void setState(State state) {
        this.state = state;
    }
    //读取状态
    public State getState() {
        return (state);
    }
    //对请求做处理,状态的切换
    public void Handle() {
        state.Handle(this);
    }
}
