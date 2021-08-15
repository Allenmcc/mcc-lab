package designMode.atguigu.visitor.template;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
public class ConcreteVisitorB implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问-->" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者B访问-->" + element.operationB());
    }
}
