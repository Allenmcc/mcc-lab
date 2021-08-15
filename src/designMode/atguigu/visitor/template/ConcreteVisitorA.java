package designMode.atguigu.visitor.template;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */

/**
 * 具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，
 * 确定访问者访问一个元素时该做什么。
 */
public class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问-->" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->" + element.operationB());
    }
}

