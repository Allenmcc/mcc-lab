/**
 * Created by chunchen.meng on 2018/3/7.
 */
public class StaticTest {



    static {
        _i = 20;
        _i = 10;
        _i = 30;
    }
    public static int _i = 40;

    public static void main(String[] args) {
        System.out.println(_i);
    }
}
