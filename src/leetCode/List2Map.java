package leetCode;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class List2Map {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.id = 1;
        s1.name = "s1";

        Student s2 = new Student();
        s2.id = 2;
        s2.name = "s2";

        Student s3 = new Student();
        s3.id = 3;
        s3.name = "s3";

//        List<Student> students = Lists.newArrayList();
        LinkedList<Student> students = new LinkedList<>();
        students.add(s2);
        students.add(s3);
        students.add(s1);

        Map<Integer, String> map1 = students.stream().collect(Collectors.toMap(Student::getId, Student::getName, (aa, bb) -> aa));

//        Set<Integer> key = map1.keySet();
//
//        Iterator iterator = key.iterator();
//        while (iterator.hasNext()) {
//            Object k = iterator.next();
//            System.out.println(k);
//            System.out.println(map1.get(k));
//        }


        Map<Integer,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3,"a");
        linkedHashMap.put(2,"b");
        linkedHashMap.put(1,"c");

        Set<Integer> key2 = linkedHashMap.keySet();

        Iterator iterator2 = key2.iterator();
        while (iterator2.hasNext()) {
            Object k = iterator2.next();
            System.out.println(k);
            System.out.println(map1.get(k));
        }

    }
}

class Student {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}


