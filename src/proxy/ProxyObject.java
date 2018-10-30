package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chunchen.meng on 2018/10/12.
 */
public class ProxyObject   implements InvocationHandler {


    //代码的对象
    public Object targetObject;

    //绑定委托对象，并返回代理类
    public void setTargetObject(Object targetObject)
    {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        //调用，传入一个目标对象，和对应的对象参数
        System.out.println("before method");
        return method.invoke(targetObject, args);
    }


}
