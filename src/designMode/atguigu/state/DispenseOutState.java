package designMode.atguigu.state;

/**
 * 奖品发放完毕状态
 * 说明，当我们activity 改变成 DispenseOutState，抽奖活动结束
 * @author Administrator
 *
 */
public class DispenseOutState extends State {

	// 初始化时传入活动引用
    RaffleActivityContext activity;

    public DispenseOutState(RaffleActivityContext activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了，请下次参加");
    }
}
