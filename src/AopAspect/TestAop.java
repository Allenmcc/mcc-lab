package AopAspect;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chunchen.meng on 2018/2/1.
 */
public class TestAop {

    @Autowired
    TargetClass targetClass;

    @Test
    public void testAOP() {
        //1、创建Spring的IOC的容器
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean.xml");

        //2、从IOC容器中获取bean的实例
//        TargetClass targetClass = (TargetClass) ctx.getBean("targetClass");

        //3、使用bean
        String result = targetClass.joint("spring","aop");
        System.out.println("result:" + result);
    }
}
