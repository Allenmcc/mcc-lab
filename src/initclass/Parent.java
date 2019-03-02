package initclass;

/**
 * Created by chunchen.meng on 2018/11/23.
 */

// 做面
public class Parent {
    static Member smember = new Member("Parent的静态成员");
    static {
        System.out.println("Parent的静态代码块");
    }
    {
        System.out.println("Parent的非静态代码块");
    }
    Member member = new Member("Parent的非静态成员");  //同代码块
    public Parent() {
        System.out.println("Parent的构造方法");
    }

}
