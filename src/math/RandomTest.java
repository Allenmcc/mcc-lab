package math;

import java.util.Random;

/**
 * Created by chunchen.meng on 2019/8/2.
 */
public class RandomTest {

    public static void main(String[] args) {

        int result =  (int)(1+Math.random()*(10-1+1));
        System.out.println(result);

        Random rnd = new Random();
        //该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n,n不能为0。
        int code = rnd.nextInt(5);
        System.out.println("code:"+code);
    }
}
