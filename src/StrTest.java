import java.util.ArrayList;
import java.util.List;

/**
 * Created by danny on 16/6/3.
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


    }

    private static  int test(int a){
        test2(4);
        return a;


    }

    private static  int test2(int b){
        return b;


    }

}
