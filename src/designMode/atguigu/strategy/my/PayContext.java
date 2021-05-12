package designMode.atguigu.strategy.my;

/**
 * https://mp.weixin.qq.com/s/tVb17JgkH5Dz9DJ4agkWqw
 *
 * 供客户端调用，并选择具体策略
 * 环境(Context)角色： 持有一个Strategy的引用。
 */
public class PayContext {

    //依赖策略接口属性
    private PayStrategy payStrategy;

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 提供外部访问方法
     * @param money
     */
    public void payMoney(double money) {
        payStrategy.pay(money);
    }
}
