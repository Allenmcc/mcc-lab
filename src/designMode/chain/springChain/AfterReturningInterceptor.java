package designMode.chain.springChain;

/**
 * Created by chunchen.meng on 2019/6/20.
 */
public class AfterReturningInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation mi) {
        Object retVal = mi.proceed();
        afterReturning();
        return retVal;
    }

    private void afterReturning() {
        System.out.println("afterReturning");
    }
}
