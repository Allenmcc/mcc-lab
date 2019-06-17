package random;

import org.apache.commons.collections.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chunchen.meng on 2019/5/28.
 */
public class Random {
    public static void main(String[] args) {
       int result =  (int)(1+Math.random()*(10-1+1));
       System.out.println(result);

        if( 3>2){
            System.out.println("0");
        }

       if(2>1){
           System.out.println("1");
       }
       else if( 3>2){
           System.out.println("2");
       }

        if( 3>2){
            System.out.println("3");
        }

        Set<Integer>  set = new HashSet<>();
        set.add(1);

        System.out.println(set);
        if (CollectionUtils.isEmpty(set)){
            System.out.println("null");
        }


    }
}
