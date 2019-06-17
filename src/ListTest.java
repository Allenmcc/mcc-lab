import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by danny on 16/8/24.
 */

public class ListTest {

    public static void main(String[] args) {
//
        List<Integer> list1 = null;
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(4);
//        list1.add(5);
//        list1.add(6);
//        list1.add(7);
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list1+"");
        System.out.println(list2.toString());
        System.out.println(list2+"");
        List<Integer> list4 =   Lists.newArrayList(1,2);
        System.out.println(list4);

        List<Integer> aa = null;
        List<Integer> bb = Lists.newArrayList();
        List<Integer> bbb = new ArrayList<>();
        List<Integer> cc = new ArrayList<Integer>(){{addAll(bbb);}};
        System.out.println("test"+ cc);



//        for (Integer aa:list1){
//            list2.add(aa);
//        }
////        list2 = list1;
//        list2.add(8);

//        list2.add(4);
//        list2.add(5);
//        list2.add(9);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(6);
//        list3.add(7);
//        list3.add(8);

//        list1.addAll(list2);
//        list1.removeAll(list2);
//        System.out.println(list1.size());

//
//        List<List<Integer>> list4 = new ArrayList<>();
//        list4.add(list2);
//        list4.add(list1);
//        list4.add(list3);
//        System.out.println(list4);
////        System.out.println(list1.contains(2));
//        System.out.println(list1.indexOf(3));
//
//
        Map<Long, String> map = new HashMap<>();
        map.put(1L, "aa");
        map.put(2L, "ab");
        map.put(3L, "ccc");

        Long test = 1L;
       System.out.println(map.get(test));
//        List testList = Lists.newArrayList(23);
//        List testMap = Lists.newArrayList(map.keySet());
//        System.out.println(testList);
//        System.out.println(testMap);
//
//
//        Person a = new Person();
//        a.age = 1;
//        a.setScore(list1);
//        System.out.println(a.score);
//
//        a.setScore(list2);
//        System.out.println(a.score);
//
//        List<Person> peopleList = new ArrayList<>();
//        Person a1 = new Person();
//        a1.age = 200;
//        peopleList.add(a1);
//        a1.age =100;
//        System.out.println(peopleList.get(0).age);
//
//
//        int aa =1111;
//        List<Integer> list5 = new ArrayList<>();
//        list5.add(aa);
//        aa = 2222;
//
//        System.out.println(list5.get(0));
//
//
//
//        long one = 3;
//        long two = 100;
//        double result = one*100/two;
//
//        if(result<=3){
//            System.out.println("前3");
//
//        }
//        System.out.println();
//

//        List<String> aaa = new ArrayList<String>();
//        aaa.add("1");
//        aaa.add("2");
//        aaa.add("3");
//        aaa.add("4");
//
//
//
//        for (String temp : aaa){
//            if("1".equals(temp)) {
//                aaa.remove(temp);
//            }
//        }
//
//        for (String temp : aaa){
////            if("1".equals(temp)) {
//            System.out.println(temp);
////            }
//        }

        String str = "i love u";//测试用
        String[] strs = {"i like u", "i miss u"};//测试用
        /**
         * asList：返回一个不可变的List
         * 其中包含指定的第一个元素和附加的元素数组组成
         * 修改这个数组将反映到返回的List上
         */
        List<String> list = Lists.asList(str, strs);
        System.out.println(list); //[i love u, i like u, i miss u]

        List<String> list11 =new ArrayList<String>();
        list11.add("A");
        list11.add("B");
        list11.add("D");
        List<String> list22 =new ArrayList<String>();
        list22.add("B");
        list22.add("C");

//        System.out.println(list11.removeAll(list22));

        System.out.println(list11.retainAll(list22));
        System.out.println(list11);
        System.out.println(list22);


        Iterator<String> it = list11.iterator();
        while(it.hasNext()){
            String x = it.next();
//            if(x.equals("A")){
            if(list22.contains(x)){
                it.remove();
            }
        }

        System.out.println(list11);



    }
}
