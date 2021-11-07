package designMode.atguigu.responsibilitychain.definition;


/**
 * Created by allen
 */

/**
 * 抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 */
//抽象处理者角色
public abstract class Handler {

    //私有 需要提供访问方法getNext()
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    //暴露 Handler next;
    public Handler getNext() {
        return next;
    }

    //处理请求的方法
    public abstract void handleRequest(String request);
}
