package designMode.atguigu.visitor.template;/**
 * Created by winwin on 2021/8/15.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by allen
 */
//对象结构角色

/**
 * 对象结构（Object Structure）角色：是一个包含元素角色的容器，
 * 提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
 */
public class ObjectStructure {

    //元素
    private List<Element> list = new ArrayList<Element>();


    //元素被访问
    public void accept(Visitor visitor) {
        Iterator<Element> i = list.iterator();
        while (i.hasNext()) {
            ((Element) i.next()).accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }


    public void remove(Element element) {
        list.remove(element);
    }
}
