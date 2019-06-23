package designMode.chain.springChain;

/**
 * Created by chunchen.meng on 2019/6/20.
 */
public interface MethodInterceptor {
    Object invoke(MethodInvocation mi);

}
