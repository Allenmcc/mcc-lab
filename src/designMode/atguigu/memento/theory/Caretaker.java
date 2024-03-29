package designMode.atguigu.memento.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理者（Caretaker）角色：对备忘录进行管理，
 * 提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 */
public class Caretaker {

    //在list集合中会有很多备忘录对象
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    //获取到第index个Originator的备忘录对象（即保存状态）
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
