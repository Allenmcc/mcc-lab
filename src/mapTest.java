import com.google.common.collect.Lists;
import org.apache.commons.collections.map.HashedMap;

import java.util.*;

/**
 * Created by danny on 16/1/26.
 */
public class mapTest {

    public static void main(String arg[]) {
    final    Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "mcc");
        map.put("passWord", "123");
        map.put("userID", "1");
        map.put("userID", "2");
        map.put("email", "mcc@qq.com");
        map.put("cc", Lists.newArrayList(1,2));

//        map = new HashedMap();  error


        System.out.println(map.get("email"));
        System.out.println(map.get("userID"));



        boolean accessOrder =true;
        Map<String,String > linkedMap = new LinkedHashMap<>(20, .80f,accessOrder);
//        Map<String,String > linkedMap = new LinkedHashMap<>();
        linkedMap.put("username", "mcc");
        linkedMap.put("passWord", "123");
        linkedMap.put("userID", "1");
        linkedMap.put("userID", "2");
        linkedMap.put("email", "mcc@qq.com");

        System.out.println(map.get("email"));


        //第一种：普遍使用，二次取值  效率低
//        System.out.println("通过Map.keySet遍历key和value：");
//        for (String key : map.keySet()) {
//            System.out.println(key + "---->" + map.get(key));
//        }

//        System.out.println("LinkedHashMap通过Map.keySet遍历key和value：");
//        for (String key : linkedMap.keySet()) {
//            System.out.println(key + "---->" + linkedMap.get(key));
//        }

        //第二种
//        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
//        for (String value : map.values()) {
//            System.out.println(value);
//        }
//
//
//        //第三种：推荐，尤其是容量大时
//        System.out.println("通过Map.entrySet遍历key和value");
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + "---->" + entry.getValue());
//        }
//
//
//        //第四种
//        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
//        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, String> entry = it.next();
//            System.out.println(entry.getKey() + "---->" + entry.getValue());
//
//        }
//
//
//        //第五种
//        System.out.println("通过map.keySet使用iterator遍历key和value：");
//        Iterator<String> iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            String value = map.get(key);
//            System.out.println(key + "---->" + value);
//
//        }
//
//        //第六种
//        System.out.println("通过map.values使用iterator遍历value,但不能遍历key");
//        Iterator<String> iterator2 = map.values().iterator();
//        while (iterator2.hasNext()) {
//            String value = iterator2.next();
//            System.out.println(value);
//
//        }


    }

}
