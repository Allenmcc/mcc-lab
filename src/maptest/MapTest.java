package maptest;



import java.util.*;

/**
 * Created by chunchen.meng on 2019/6/11.
 */
public class MapTest {

    public static void main(String[] args) {
//        Map<Long, Map<Long, String>> big = new HashMap<Long, Map<Long,String>>();
//        for(long i = 0; i < 10; i++) {
//            Map<Long, String> small = new HashMap<Long, String>();
//            small.put(i, String.valueOf(i));
//            big.put(i, small);
//        }
//        System.out.println(big);
//
//        long key = 2L;
//        System.out.println(big.get(key));
//        int k2 = 2;
//        System.out.println(big.get(k2));

        //initialCapacity = (需要存储的元素个数 / 负载因子) + 1公式计算后设置
        //反例：HashMap需要放置1024个元素，由于没有设置容量初始大小，随着元素不断增加，容量7次被迫扩大，resize需要重建hash表，严重影响性能。
        Map<String, Object> map = new HashMap<>(4);
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        map.put("5","e");
        map.put("6","e");
        map.put("7","e");
        map.put("8","e");

        System.out.println(map);



        //key can null
        Map<String,String> ntest = new HashMap<>();
        ntest.put(null,"nulltest");
        ntest.get(null);
        System.out.println(ntest);
        System.out.println(ntest.get(3));  //null
        System.out.println(ntest.get(null));  //nulltest


        // key can not null
        Hashtable<String,String> nTable = new Hashtable<>();
        nTable.put(null,"nulltest");
        nTable.put(null,null);
        System.out.println(nTable);

    }
}
