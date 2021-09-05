package designMode.atguigu.iterator.travel;

/**
 * Created by winwin on 2021/9/5.
 * 是具体聚合类，用 ArrayList 来保存所有景点信息，并实现父类中的抽象方法；
 * 再定义婺源景点的抽象迭代器（ViewSpotltemtor）接口，其中包含了查看景点信息的相关方法。
 */

//抽象聚合：婺源景点集接口
public interface ViewSpotSet {

    void add(WyViewSpot obj);

    void remove(WyViewSpot obj);

    ViewSpotIterator getIterator();
}
