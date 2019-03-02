package initclass.mainmethod;

/**
 * Created by chunchen.meng on 2018/11/23.
 */
public class Code {
    {
        System.out.println("Code的构造块");
    }

    static{
        System.out.println("Code的静态代码块");
    }

    public Code(){
        System.out.println("Code的构造方法");
    }
}
