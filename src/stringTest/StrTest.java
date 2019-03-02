package stringTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 16/6/3.
 *
 * https://www.cnblogs.com/dolphin0520/p/3778589.html
 */
public class StrTest {

    public static void main(String args[]) {
        List<Integer> shopIds = new ArrayList<Integer>();
        shopIds.add(1);
        shopIds.add(2);
        shopIds.add(3);
        shopIds.add(4);
        String shopIdStr = "";

        for (int shopId : shopIds) {
            shopIdStr += shopId + "";

        }
        System.out.println(shopIdStr);
        System.out.println(test(3));

        if(3==2){
            System.out.println("3==2");

        }
        if(3!=3){
            System.out.println("3!=2");

        }else {
            System.out.println("else");
        }


        //Immutable
        String immuStr = "hello";
        String immuStr2 = "hello";
        immuStr2 = immuStr+ "ni";
        System.out.println(immuStr);
        System.out.println(immuStr2);


        String a = "hello2";
        final String b = getHello();
        String c = b + 2;
        System.out.println((a == c));

    }

    public static String getHello() {
        return "hello";
    }

    private static  int test(int a){
        test2(4);
        return a;


    }

    private static  int test2(int b){
        return b;


    }

}
