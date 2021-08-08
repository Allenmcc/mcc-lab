package designMode.atguigu.state.score;

/**
 * 环境类（Context）角色：也称为上下文，它定义了客户端需要的接口，
 * 内部维护一个当前状态，并负责具体状态的切换。
 *
 * 定义环境类（ScoreContext），其中包含了当前状态对象和加减分的方法 add(int score)，
 * 客户类通过该方法来改变成绩状态。
 */
public class ScoreContext {

    //内部维护一个当前状态，并负责具体状态的切换。
    private AbstractState state;
    ScoreContext() {
        //默认初始化
        state = new LowState(this);
//        state = new HighState(this);
    }
    public void setState(AbstractState state) {
        this.state = state;
    }

    public AbstractState getState() {
        return state;
    }

    //维护状态，并且状态切换
    public void add(int score) {
        state.addScore(score);
    }
}
