package string;

/**
 * Created by chunchen.meng on 2018/11/27.
 */
public class equaltest {

    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

    }
}
