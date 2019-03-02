package initclass;

/**
 * Created by chunchen.meng on 2018/11/23.
 */

/**
 初始化父类的静态成员
 初始化父类的静态代码块
 初始化子类的静态成员
 初始化子类的静态代码块
 初始化父类的非静态成员 初始化父类的非静态代码块（随在上面优先）
 初始化父类的构造方法
 初始化子类的非静态成员 初始化子类的非静态代码块 随在上面优先）
 初始化子类的构造方法
 注：父类及子类的静态成员和静态代码块只在程序运行时加载一次。
 */
public class App
{
    static {
        System.out.println("APP static代码块");
    }
    public static void main( String[] args )
    {

        System.out.println("APP main方法");
        SubClass subClass = new SubClass();

        System.out.println("subClass1  第二次");
        SubClass subClass1 = new SubClass();
    }
}
