package proxy.cglibProxy;

/**
 * Created by chunchen.meng on 2019/6/10.
 */
public class DoCGLib {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        //运行期间，通过生成子类的方式创建代理类，没有接口也可以织入(不同于jdk的动态代理)
        SayHello proxyImp = (SayHello)proxy.getProxy(SayHello.class);
        proxyImp.say();
    }
}
