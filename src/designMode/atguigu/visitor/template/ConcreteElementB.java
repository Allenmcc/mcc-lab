package designMode.atguigu.visitor.template;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */

/**
 * 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，
 * 其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
 */
public class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作。";
    }
}
