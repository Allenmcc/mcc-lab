package jvmtest.gctest;


/**
 * https://blog.csdn.net/u010798968/article/details/72835255
 *
 * GCRoots 测试：虚拟机栈（栈帧中的局部变量）中引用的对象作为GCRoots
 *  -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *  扩展：虚拟机栈中存放了编译器可知的八种基本数据类型,对象引用,returnAddress类型（指向了一条字节码指令的地址）
 *
 */
public class TestGCRoots01 {
    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    public static void main(String[] args) {
        method01();
        System.out.println("返回main方法");
        System.gc();
        //method01方法执行完后，局部变量t跟随方法消失，不再有引用类型指向该对象，该对象在Full GC后，被完全回收，老年代腾出该对象之前所占的空间。
        System.out.println("第二次GC完成");
    }

    public static void method01() {
        TestGCRoots01 t = new TestGCRoots01();
        System.gc();
        //第一次GC：
        //t为局部变量，引用了new出的对象（80M），作为GC Roots，在Minor GC后被转移到老年代中，且Full GC也不会回收该对象，仍保留在老年代中。
        System.out.println("第一次GC完成");
    }

}
