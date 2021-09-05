package designMode.atguigu.iterator.travel;


/**
 * Created by allen
 * 它实现了父类的抽象方法；客户端程序设计成窗口程序，它初始化婺源景点集（ViewSpotSet）中的数据，
 * 并实现 ActionListener 接口，它通过婺源景点迭代器（ViewSpotlterator）来査看婺源景点
 * （WyViewSpot）的信息
 */
//抽象迭代器：婺源景点迭代器接口
public interface ViewSpotIterator {

    boolean hasNext();

    WyViewSpot first();

    WyViewSpot next();

    WyViewSpot previous();

    WyViewSpot last();
}
