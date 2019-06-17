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
        double a=0.03;
        double b=0.02;
        double c=a-b;
        System.out.println(c);

        BigDecimal aa = new BigDecimal("0.03");
        BigDecimal bb = new BigDecimal("0.02");
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

    }

}
