package interfaceTest;

/**
 * Created by chunchen.meng on 2018/10/1.
 */
public class TestCeshi {

    public static void main(String[] args) {

        UseCompute a =new UseCompute();
        a.useCom(new Jia(), 2, 2);

        a.useCom(new Jian(), 2, 2);

        a.useCom(new Cheng(), 2, 2);

        a.useCom(new Chu(), 2, 2);

        Compute aa =new Jia();
        System.out.println(aa.computer(3,5));



    }
}
