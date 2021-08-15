package designMode.atguigu.visitor.template;/**
/**
 * Created by allen
 */


/**
 * 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，
 * 其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
 *
 * 将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，
 */
public class ConcreteElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作。";
    }
}
