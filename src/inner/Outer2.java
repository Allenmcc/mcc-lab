package inner;

/**
 * Created by chunchen.meng on 2018/11/28.
 */
public class Outer2 {

    abstract class AbsDemo
    {
        abstract void show();
    }


    int x=3;

    public void function()//可调用函数
    {
        new AbsDemo()//匿名内部类
        {
            @Override
            void show()
            {
                System.out.println("x==="+x);
            }
            void abc()
            {
                System.out.println("haha");
            }
        }.abc();  //匿名内部类调用函数,匿名内部类方法只能调用一次
    }
}
