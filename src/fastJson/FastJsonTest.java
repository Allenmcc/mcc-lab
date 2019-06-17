package fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chunchen.meng on 2018/3/30.
 */
public class FastJsonTest {

    public static void main(String[] args){
//        String jsonStr = "[{\"JACKIE_ZHANG\":\"张学友\"},{\"ANDY_LAU\":\"刘德华\"},{\"LIMING\":\"黎明\"},{\"Aaron_Kwok\":\"郭富城\"}]" ;
//        //做5次测试
//        for(int i=0,j=5;i<j;i++)
//        {
//            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
//
//            for(int k=0;k<jsonArray.size();k++){
//                System.out.print(jsonArray.get(k) + "\t");
//            }
//            System.out.println();//用来换行
//        }


        Map<Integer,String>  map = new HashMap<>();

        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"b");
        map.put(4,"d");
        map.put(5,"e");
        String str =  JSON.toJSONString(map);




        System.out.println(map);

        map.remove(5);
        System.out.println(map);
        System.out.println(str);

        JSONObject js = JSONObject.parseObject(str);

        System.out.println(js);

      Map<Integer,String> map1 =  JSONObject.toJavaObject(js,Map.class);



        Object jsonObject =  JSONObject.parse(str);
        System.out.println(jsonObject);



        List<User> users = Lists.newArrayList();
        User user = new User();
        user.setAge(1);
        user.setName("cc");
        User user2 = new User();
        user2.setAge(2);
        user2.setName("c2");
        users.add(user);
        users.add(user2);
        System.out.println(JSON.toJSONString(users));


        JSONArray jsonArray =    JSONArray.parseArray(JSON.toJSONString(users));
        System.out.println(jsonArray);
//        System.out.println(JSON.toJSONString(users));

    }
}
