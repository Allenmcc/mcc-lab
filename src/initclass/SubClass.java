package initclass;

/**
 * Created by chunchen.meng on 2018/11/23.
 */

//收银
public class SubClass extends Parent {
    Member member = new Member("SubClass的非静态成员");
    static Member smember = new Member("SubClass的静态成员");
    static{
        System.out.println("SbuClass的静态代码块");
    }
    {
        System.out.println("SbuClass非静态码块");
    }
    public SubClass(){
        System.out.println("SubClass的无参数构造方法");
    }
}
