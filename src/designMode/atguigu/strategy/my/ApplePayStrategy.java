package designMode.atguigu.strategy.my;

/**
 * 具体策略(ConcreteStrategy)角色： 包装了相关的算法或行为。
 */
public class ApplePayStrategy implements PayStrategy {

    @Override
    public void pay(double money) {
        double payMoney = money * 0.82;
        double discountMoney = money - payMoney;
        System.out.println("使用Apple pay成功支付" + payMoney + "元,优惠" + discountMoney + "元");
    }
}
