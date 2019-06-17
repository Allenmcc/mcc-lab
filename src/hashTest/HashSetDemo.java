package hashTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by chunchen.meng on 2019/2/24.
 */
public class HashSetDemo {
    public static void main(String[] args) {
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
