package designMode.atguigu.responsibilitychain.definition;

/**
 * Created by allen
 */

/**
 * 客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，
 * 它不关心处理细节和请求的传递过程。
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {

        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
