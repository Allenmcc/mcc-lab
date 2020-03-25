package interfaceTest;

/**
 * Created by chunchen.meng on 2018/10/1.
 */
public class TestCeshi {

    public static void main(String[] args) {

        UseCompute a =new UseCompute();
        //入参 接口的实现类 （非匿名）
        a.useCom(new Jia(), 2, 2);

        a.useCom(new Jian(), 2, 2);

        a.useCom(new Cheng(), 2, 2);

        a.useCom(new Chu(), 2, 2);

        //实现入参（匿名类）
        a.useCom(new Compute() {
            @Override
            public int computer(int n, int m) {
                return n*m+1;
            }
        },2,3);

        //实现入参（匿名类） lambda 函数式编程(类scala)
        a.useCom((n, m) -> {
            return n+m+1; //返回int
        },2,3);

        //一行省略{}
        a.useCom((n, m) -> n+m+1 ,2,3);

        Compute aa =new Jia();
        System.out.println(aa.computer(3,5));





    }
}
