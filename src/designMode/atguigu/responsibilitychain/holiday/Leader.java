package designMode.atguigu.responsibilitychain.holiday;

/**
 * Created by allen
 */

/**
 * 抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 */
//抽象处理者：领导类
public abstract class Leader {

    private Leader next;

    public void setNext(Leader next) {
        this.next = next;
    }

    public Leader getNext() {
        return next;
    }

    //处理请求的方法
    public abstract void handleRequest(int LeaveDays);
}
