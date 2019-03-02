package initclass;

/**
 * Created by chunchen.meng on 2018/11/23.
 */

/**
 初始化父类的静态成员
 初始化父类的静态代码块
 初始化子类的静态成员
 初始化子类的静态代码块
 初始化父类的非静态成员
 初始化父类的非静态代码块
 初始化父类的构造方法
 初始化子类的非静态成员
 初始化子类的非静态代码块
 初始化子类的构造方法
 注：父类及子类的静态成员和静态代码块只在程序运行时加载一次。
 */
public class Z extends X {
    static {
        System.out.println("Z静态代码块");
    }
    Y y  = new Y();
    public Z(){
        System.out.println("Z");
    }

    public static void main(String[] args) {
        new Z();
    }
}
class  X{

//    Y y = new Y();

    public X(){
        System.out.println("X");
    }
    {
        System.out.println("X非静态代码块");

    }
    Y y = new Y(); //无括号，同非静态代码块
}
class  Y{

    {
        System.out.println("Y非静态代码块");
    }

    public Y(){
        System.out.println("Y");
    }
}
