package designMode.atguigu.visitor.template;/**
 * Created by winwin on 2021/8/15.
 */

/**
 * Created by allen
 */
//抽象访问者
//提供方法，让访问者可以访问
public interface Visitor {

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}
