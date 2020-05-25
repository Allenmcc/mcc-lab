package maptest;

import org.junit.Test;

import java.util.*;


/**
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265117109276544
 * https://www.jianshu.com/p/dd746074f390
 */
public class TreeMapTest {

    /**
     * TreeMap->NavigableMap->SortedMap->Map
     * 默认按字母排序,String已经实现了Comparable接口
     */
    @Test
    public void test() {

        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear
    }


    /**
     * 使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，compareTo 方法直接用
     * 因此可以直接作为Key使用。作为Value的对象则没有任何要求。
     * 如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
     */
    @Test
    public void test2() {

        Map<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        map.put(new Person("Tom"), 1);
        map.put(new Person("Bob"), 2);
        map.put(new Person("Lily"), 3);
        for (Person key : map.keySet()) {
            System.out.println(key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println(map.get(new Person("Bob"))); // 2
    }

    class Person {
        public String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "{Person: " + name + "}";
        }
    }


    @Test
    public void test3() {
        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {

            //没有使用compareTo ,所以相等不相等情况都要实现
            @Override
            public int compare(Student p1, Student p2) {
                if (p1.score == p2.score) {
                    return 0;
                }
                return p1.score > p2.score ? -1 : 1;
            }
        });
        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Student("Bob", 66))); // null?
        //在p1.score和p2.score不相等的时候，它的返回值是正确的，但是，在p1.score和p2.score相等的时候，它并没有返回0！
        // 这就是为什么TreeMap工作不正常的原因：TreeMap在比较两个Key是否相等时，依赖Key的compareTo()方法
        // 或者Comparator.compare()方法。在两个Key相等时，必须返回0。因此，修改代码如下：
        // if (p1.score == p2.score) {
        //                    return 0;
        //                }
    }

    class Student {
        public String name;
        public int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("{%s: score=%d}", name, score);
        }
    }


    @Test
    public void testValueCompator() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 5);
        hashMap.put(2, 4);
        hashMap.put(3, 3);
        hashMap.put(4, 2);
        hashMap.put(5, 1);
        hashMap.put(7, 1);

        //hashmap 无序
        System.out.println(hashMap);

        // 创建Value比较器
        ValueComparator valueComparator = new ValueComparator(hashMap);
        // 创建TreeMap
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(valueComparator);
        //TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        // 将HashMap中所有数据放入 TreeMap中
//        treeMap.putAll(hashMap);
        // 为了观察每次变化，进行分开put

//        System.out.println("--------------------- put into TreeMap --------------------");
        System.out.println(treeMap.put(1, 5));
        System.out.println(treeMap.put(2, 4));
        System.out.println(treeMap.put(3, 3));
        System.out.println(treeMap.put(4, 2));
        System.out.println(treeMap.put(5, 1));
        System.out.println(treeMap.put(7, 1));

        System.out.println("---------------------- sort result -------------------------");
        // 迭代TreeMap的结果
        Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
        }
        System.out.println("after sorted, the size : " + treeMap.size());

    }
    class ValueComparator implements Comparator<Integer> {

        // 一定要持有能根据Key的值找到对应Value值的Map，只有这样才能在compare方法中比较key对应的value
        // 默认传入的比较器都是针对key的比较器，
        // 如果想修改为Value的比较器需要通过持有k-v的Map!!!!!!!
        private Map<Integer, Integer> map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        @Override
        public int compare(Integer o1, Integer o2) {

            if (map.get(o1) > map.get(o2)) {
                return 1;
            } else if (map.get(o1) < map.get(o2)) {
                return -1;
            }
            // 如果比较value，相同的value的Key将会发生合并，即Value的值是不允许重复的
            // 相等情况,必须返回 0，否则get方法将返回null
            return 0;
        }
    }
}
