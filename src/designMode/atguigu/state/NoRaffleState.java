package designMode.atguigu.state;

/**
 * 不能抽奖状态
 * @author Administrator
 *
 */
public class NoRaffleState extends State {

	 // 初始化时传入活动引用，扣除积分后改变其状态
    //关联关系,双向一对一
    RaffleActivityContext activity;

    public NoRaffleState(RaffleActivityContext activity) {
        this.activity = activity;
    }

    // 当前状态可以扣积分，扣除后，将状态设置成可以抽奖的状态
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    // 当前状态不能抽奖
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖哦");
        return false;
    }

    // 当前状态不能发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
