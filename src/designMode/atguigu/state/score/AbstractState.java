package designMode.atguigu.state.score;

/**
 * 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为，
 * 可以有一个或多个行为。
 *
 * 定义一个抽象状态类（AbstractState），其中包含了环境属性、状态名属性和当前分数属性，以及加减分方法
 * addScore(int x) 和检查当前状态的抽象方法 checkState()。
 */
public abstract class AbstractState {

    protected ScoreContext hj;  //环境
    protected String stateName; //状态名
    protected int score; //分数

    public abstract void checkState(); //检查当前状态,用以封装环境对象中的特定状态所对应的行为

    public void addScore(int x) {
        score += x;
        System.out.print("加上：" + x + "分，\t当前分数：" + score);
        checkState();
        System.out.println("分，\t当前状态：" + hj.getState().stateName);
    }
}
