package fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;

import javax.xml.ws.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

        String  testJson = "{\"resultcode\":\"200\",\"reason\":\"成功的返回\",\"result\":{\"area\":\"浙江省温州市平阳县\",\"sex\":\"男\",\"birthday\":\"1989年03月08日\"}}";
        ResopnseUser response1 =  JSONObject.parseObject(testJson,ResopnseUser.class);

        final Type  type= new TypeReference<ResopnseUser>(){}.getType();
        ResopnseUser response2 =  JSONObject.parseObject(testJson,type);
        ResopnseUser response3 =  JSONObject.parseObject(testJson, new TypeReference<ResopnseUser>(){});
        Response response4 =  JSONObject.parseObject(testJson, new TypeReference<Response<ResopnseUser>>(){});
        Response<ResopnseUser> response5 =  JSONObject.parseObject(testJson,Response.class);

        System.out.println(response1);
        System.out.println(response2);
        System.out.println(response3);
        System.out.println(response4);
        System.out.println(response5);

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");

        JSONObject o = new JSONObject();
        o.put("k",list);

        List<String> types = o.getObject("k",List.class);
        System.out.println(JSON.toJSONString(types));

        List<String> types2 = o.getObject("k",new TypeReference<List<String>>(){});
        System.out.println(JSON.toJSONString(types2));

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(9);
//        list.add(4);
//        list.add(8);
//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("a", list);
//        System.out.println(jsonObj);
//
//        List<String> list2 = jsonObj.getObject("a", new TypeReference<List<Integer>>(){});
//
//        System.out.println(list2);



    }
}
