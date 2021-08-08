package designMode.atguigu.state.score;

/**
 * 具体状态类：优秀
 * 具体状态（Concrete State）角色：实现抽象状态所对应的行为，并且在需要的情况下进行状态切换。
 */
public class HighState extends AbstractState  {

//    public HighState(ScoreContext h) {
//        hj = h;
//        stateName = "优秀";
//        score = 0;
//    }

    public HighState(AbstractState state) {
        hj = state.hj;
        stateName = "优秀";
        score = state.score;
    }

    @Override
    public void checkState() {
        if (score < 60) {
            hj.setState(new LowState(this));
        } else if (score < 90) {
            hj.setState(new MiddleState(this));
        }
    }
}
