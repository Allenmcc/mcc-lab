import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 2016/12/28.
 */
public class batchArray {


    private static void batchList(String users[]) {
        List<String> poiShopIds = Lists.newArrayList(users);

        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < poiShopIds.size(); i++) {
            tempList.add(poiShopIds.get(i));
            if ((i + 1) % 2 == 0 || (i + 1) == poiShopIds.size()) {
                System.out.println(poiShopIds.get(0));
                String[] tes = tempList.toArray(new String[tempList.size()]);
                System.out.println(tes[1]);
                tempList.clear();
            }
        }

    }

    public static void main(String arg[]) {
        String users[] = {"1", "2", "1", "2", "1", "2"};
//        batchList(users);
        String test = "哈大daasdal;da;dsa";
        System.out.println(test.length()>4?test.substring(0,10)+"...":test);


//        String users[] = {"1", "2", "1", "2", "1", "2"};
//        String[] batchUsers = new String[2];      //数组大小固定
////        ArrayList<String> strArr = new ArrayList<>();
//        Lists.newArrayList(users);
//        for (int i = 0,j=0; i < users.length; i++,j++) {
//
//            batchUsers[j] = users[i];
//            if ((i + 1) % 2 == 0 || (i + 1) == users.length) {
//                //// TODO: 2016/12/28
//                System.out.println(batchUsers[0]);
//                batchUsers = null;
//                j=-1;
//            }
//
//        }
    }
}