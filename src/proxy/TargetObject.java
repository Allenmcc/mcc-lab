package proxy;

/**
 * Created by chunchen.meng on 2018/10/12.
 */
public class TargetObject implements ProxyInterFace {


    @Override
    public void proxyMethod()
    {
        System.out.println("我被代理了，哈哈！");
    }

}
