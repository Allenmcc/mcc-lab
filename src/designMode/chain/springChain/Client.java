package designMode.chain.springChain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chunchen.meng on 2019/6/20.
 * 同chain1
 *
 */
public class Client {
    public static void main(String[] args) {
        List<MethodInterceptor> interceptors = Arrays.asList(

                new MethodBeforeInterceptor(),
                new AfterReturningInterceptor()
        );
        ReflectiveMethodInvocation invocation = new ReflectiveMethodInvocation(interceptors);
        invocation.proceed();
    }
    /**
     * 运行结果与List<MethodInterceptor>中interceptor的顺序有关吗？
     把new AfterReturningInterceptor()和new MethodBeforeInterceptor()换下顺序，结果会不同吗？
     答案：无关，不会。
     */
}
