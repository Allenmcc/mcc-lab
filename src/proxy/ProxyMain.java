package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by chunchen.meng on 2018/10/12.
 */
public class ProxyMain {

    public static void main(String[] args) {

        //代理的目标对象
        ProxyInterFace proxyInterface = new TargetObject();
        //代理器
        ProxyObject proxyObject = new ProxyObject();
        proxyObject.setTargetObject(proxyInterface);

        //转换成InvocationHandler
        InvocationHandler handler = proxyObject;
        //执行代码任务  生成代理类
        Object proxy = Proxy.newProxyInstance(proxyInterface.getClass().getClassLoader(), proxyInterface.getClass().getInterfaces(), handler);

        //com.sun.proxy.$Proxy0
        System.out.println(proxy.getClass().getName());

        //转换成目标对象，调用目标对象的方法
        ((ProxyInterFace) proxy).proxyMethod();
    }


}
