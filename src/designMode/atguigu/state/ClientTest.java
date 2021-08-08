package designMode.atguigu.state;

/**
 *
 * @author Administrator
 *
 */
public class ClientTest {

	public static void main(String[] args) {
		// 创建活动对象，奖品有一个奖品
        RaffleActivityContext activity = new RaffleActivityContext(1);

        // 连续抽300次奖品
        for (int i = 0; i < 30; i++) {
            System.out.println("--------第" + (i + 1) + "次抽奖----------");
            // 参加抽奖，第一步点击扣除积分
            activity.deductMoney();

            // 第二部抽奖
            activity.raffle();
        }
	}

}
