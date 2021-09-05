package designMode.atguigu.iterator.school;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen
 * 具体聚合（ConcreteAggregate）角色：实现抽象聚合类，返回一个具体迭代器的实例。
 */
public class ConcreteAggregate implements Aggregate {

    private List<Object> list = new ArrayList<Object>();


    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);

    }

    @Override
    public Iterator getIterator() {
        return (new ConcreteIterator(list));
    }
}
