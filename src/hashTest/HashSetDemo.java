package hashTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by chunchen.meng on 2019/2/24.
 */
public class HashSetDemo {
    public static void main(String[] args) {

        //HashSet实现了Set接口，它不允许集合中有重复的值，
        //当我们提到HashSet时，第一件事情就是在将对象存储在HashSet之前，
        //要先确保对象重写equals()和hashCode()方法，这样才能比较对象的值是否相等，
        // 以确保set中没有储存相等的对象。如果我们没有重写这两个方法，将会使用这个方法的默认实现。

        Collection set = new HashSet();
        set.add(new Person("张三", 21));
        set.add(new Person("李四", 19));
        set.add(new Person("王五", 22));
        set.add(new Person("张三", 21));
        set.add(new Person("张三", 23));
        sop(set);
    }
    private static void sop(Collection set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Person p = (Person) it.next();
            System.out.println(p.toString());
        }
    }
}
