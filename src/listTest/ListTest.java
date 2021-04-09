package listTest;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.ListableBeanFactory;

import java.util.*;

/**
 * Created by danny on 16/8/24.
 */

public class ListTest {

    public static void main(String[] args) {
//
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list222 = new ArrayList<Integer>(){};
        List<Integer> list33 = new ArrayList<Integer>(){};
//        List<Integer> list222 = new ArrayList<Integer>(){{add(1);add(22);}};
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);

//        list33.add(4);
//        list33.add(40);
        list1.removeAll(list33);

//        list1.clear();

        list1.addAll(list222);

        List<List<Integer>> listLists = Lists.newArrayList();
        listLists.add(list1);
        listLists.add(list33);

        final int[] tmp = new int[10];
//        final int[] tmp = {0,1};

        list1.forEach(p->{

            tmp[0] += p;
            tmp[1] += p;

        });
        System.out.println(tmp[0]);
        System.out.println(tmp[1]);

        list1.forEach(System.out::println);

        list1.add(2,22);
        list1.add(1,22);

        System.out.println(list1);


        //通俗一点的说，就像洗牌一样，随机打乱原来的顺序。
        Collections.shuffle(list1);

//        list1.removeAll(list222);

        System.out.println(list1);
        System.out.println(list1.subList(0,2));
        System.out.println(list1);

        System.out.println(list1.toArray()[3]);

        List<Integer> list2 = new ArrayList<>();
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


        /**
         * 1.ArrayList是Array的复杂版本；
         2.存储的数据类型：Array只能存储相同数据类型的数据，而ArrayList可以存储不同数据类型的数据；
         3.长度的可变：Array的长度是固定的，而ArrayList的长度是可变的。
         */

        int[]d = new int[2];
        Integer dd[]  = new Integer[2];
        //数组->list
        List<Integer> listArray[] = new ArrayList[5];
        List<Integer > testt = new ArrayList<>(5);

        List<List<Integer>> listArray2 =Lists.newArrayList();

        listArray[1] = new ArrayList<>();
        listArray[1].add(12);
        listArray[1].add(13);
        listArray[1].add(14);
        listArray[1].add(15);
        listArray[1].add(16);

        System.out.println(listArray[1]);



    }
}
