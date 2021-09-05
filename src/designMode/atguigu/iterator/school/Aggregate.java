package designMode.atguigu.iterator.school;

/**
 * Created by allen
 * 抽象聚合（Aggregate）角色：定义存储、添加、删除聚合对象以及创建迭代器对象的接口。
 */
public interface Aggregate {

    public void add(Object obj);

    public void remove(Object obj);

    public Iterator getIterator();
}
