package designMode.chain.springChain;

/**
 * Created by chunchen.meng on 2019/6/20.
 */
public class MethodBeforeInterceptor implements  MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation mi) {
        before();
        return mi.proceed();
    }

    private void before() {
        System.out.println("Method before");
    }
}
