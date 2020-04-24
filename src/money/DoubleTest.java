package money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by chunchen.meng on 2019/2/22.
 *
 * https://blog.csdn.net/z956281507/article/details/79188081
 * https://blog.csdn.net/tiankong_12345/article/details/80259911
 */
public class DoubleTest {

    public static void main(String[] args) {


        double a0=0.00d;
        Double aaa0 = 0.0;
        System.out.println(aaa0.equals(0.000d));
        System.out.println(a0);
        double a=0.03;
        double b=0.02;
        double c=a-b;
        System.out.println(c);

        BigDecimal aa = new BigDecimal("0.03");
        BigDecimal aaaa = new BigDecimal("0.03");
        BigDecimal aaaaa = new BigDecimal("0.000000");
        BigDecimal bb = new BigDecimal("0.02");

        System.out.println(aaaaa.compareTo(new BigDecimal("0.00")));
        System.out.println(aaaaa.compareTo(BigDecimal.ZERO));

        System.out.println(aa.compareTo(aaaa));

        System.out.println(aa.subtract(bb));


        BigDecimal bd1 = new BigDecimal("2.15");
        BigDecimal bd2 = new BigDecimal("1.10");
        System.out.println("BigDecimal,参数为String类型运算结果:\n" + bd1 + "-" + bd2 + "=" + bd1.subtract(bd2) + "\n");

        BigDecimal bd3 = new BigDecimal(2.15);
        BigDecimal bd4 = new BigDecimal(1.10);
        System.out.println("BigDecimal,参数为double类型时运算结果:\n" + bd3 + "-" + bd4 + "=" + bd3.subtract(bd4) + "\n");


        String aaa = "hello2";
        String bbb = "hello" + 2;
        System.out.println((aaa == bbb));


        BigDecimal d1 = new BigDecimal("5.225").setScale(2, RoundingMode.HALF_UP);
        BigDecimal dd1 = new BigDecimal(5.225).setScale(2, RoundingMode.HALF_UP);
        BigDecimal d2 = new BigDecimal(5.2251).setScale(2, RoundingMode.HALF_UP);
        System.out.println(d1); //输出5.23
        System.out.println(dd1); //输出5.22
        System.out.println(d2); //输出5.23

        System.out.println(2100000* 1.2d);
        System.out.println(14.40* 1.2d);
        System.out.println(0.02* 1.2d);
        System.out.println(28560000* 1.2d);

        BigDecimal a1 = new BigDecimal(28560000);
        BigDecimal aa1 = new BigDecimal(1.2);
        System.out.println(a1.multiply(aa1).doubleValue());

        Double e = 0d;
        System.out.println(e.equals(0d));

        BigDecimal add1 = new BigDecimal("0.00").setScale(2,RoundingMode.HALF_UP);;

        System.out.println("add :"+ add1.add(d2));

        BigDecimal now = new BigDecimal(220.00);
        BigDecimal before = new BigDecimal(910.00);
        BigDecimal re = now.subtract(before).divide(before,3, BigDecimal.ROUND_HALF_UP);

        System.out.println(re);


        BigDecimal before2 = new BigDecimal("0.00");
        //Bigdecimal的equals方法不仅仅比较值的大小是否相等，首先比较的是scale（scale是bigdecimal的保留小数点位数，比如 new Bigdecimal("1.001"),scale为3），也就是说，不但值得大小要相等，保留位数也要相等，equals才能返回true。
        System.out.println(before2.equals(BigDecimal.ZERO));
        //b.compareTo(BigDecimal.ZERO)==0，可以比较是否等于0，返回true则等于0，返回false，则不等于0
        System.out.println(before2.compareTo(BigDecimal.ZERO)== 0);

    }

}
