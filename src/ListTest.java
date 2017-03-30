import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by danny on 16/8/24.
 */

public class ListTest {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(7);
        list3.add(8);

        List<List<Integer>> list4 = new ArrayList<>();
        list4.add(list2);
        list4.add(list1);
        list4.add(list3);
        System.out.println(list4);
//        System.out.println(list1.contains(2));
        System.out.println(list1.indexOf(3));


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aa");
        map.put(2, "ab");
        map.put(3, "ccc");
        List testList = Lists.newArrayList(23);
        List testMap = Lists.newArrayList(map.keySet());
        System.out.println(testList);
        System.out.println(testMap);


        Person a = new Person();
        a.age = 1;
        a.setScore(list1);
        System.out.println(a.score);

        a.setScore(list2);
        System.out.println(a.score);


    }
}
