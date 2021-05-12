package designMode.atguigu.strategy.my;

/**
 * 抽象策略(Strategy)角色： 这是一个抽象角色，通常由一个接口或抽象类实现。
 * 此角色给出所有的具体策略类所需的接口。
 *
 * 将多个业务节点具备的共同算法再次顶层抽象为接口，处理不同业务需求时，则产生的行为不同，
 * 即具体行为由其实现类解决；注重词：相同算法，，顶层抽出。
 */
public interface PayStrategy {

    void pay(double money);
}
