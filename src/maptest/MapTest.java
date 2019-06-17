package maptest;



import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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
