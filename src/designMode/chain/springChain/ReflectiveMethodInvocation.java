package designMode.chain.springChain;

import java.util.List;

/**
 * Created by chunchen.meng on 2019/6/20.
 *
 * 类似于chain1的Chain，各个interceptors的关系维护
 * 执行拦截器链的调用
 */
public class ReflectiveMethodInvocation implements MethodInvocation{

    private List<MethodInterceptor> interceptors;

    public ReflectiveMethodInvocation(List<MethodInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    private int currentInterceptorIndex = -1;

    @Override
    public Object proceed() {
        if (currentInterceptorIndex == interceptors.size() - 1) {
            System.out.println("invoke target method");
            return "obj after invoke target method";
        }
        return interceptors.get(++currentInterceptorIndex).invoke(this);
    }

}
