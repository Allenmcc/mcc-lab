package string;

import java.util.Objects;

/**
 * Created by chunchen.meng on 2018/11/27.
 * a.equals(b)：如果此时a为null，则在程序运行的时候，会发生空指针异常
 *
 * Objects.equals(a，b)：如果两个参数都为 null， Objects.equals(a，b) 调用将返回 true ;
 * 如果其中一个参数为 null ,则返回 false ; 否则，如果两个参数都不为 null， 则调用 a.equals(b)
 *
 */
public class Equaltest {

    public static void main(String[] syncargs) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


        Integer aa = null;
        Integer bb = null;
        System.out.println(Objects.equals(aa,bb));

        //npe
        System.out.println(aa.equals(bb));

    }
}
