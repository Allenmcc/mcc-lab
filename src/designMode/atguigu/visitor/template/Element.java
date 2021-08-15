package designMode.atguigu.visitor.template;

/**
 * Created by allen on 2021/8/15.
 */


/**
 * 抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，
 * 被接受的访问者对象作为 accept() 方法的参数。
 */
public interface Element {
    /**
     * 稳定的数据结构
     * @param visitor
     */
    void accept(Visitor visitor);

}
