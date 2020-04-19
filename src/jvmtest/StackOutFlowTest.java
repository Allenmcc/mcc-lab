package jvmtest;

/**
 * 栈溢出测试StackOverflowError 分配固定大小超出限制 -Xss
 * 默认情况：count:10823
 * 设置栈的大小：-Xss256k:count :1874
 *
 *
 */
public class StackOutFlowTest {

    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
