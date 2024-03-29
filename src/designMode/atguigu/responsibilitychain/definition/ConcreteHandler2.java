package designMode.atguigu.responsibilitychain.definition;


/**
 * Created by allen
 */
/**
 * 具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，
 * 判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 */
//具体处理者角色1
public class ConcreteHandler2 extends Handler {

    @Override
    public void handleRequest(String request) {

        if (request.equals("two")) {
            System.out.println("具体处理者2负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }

    }
}
