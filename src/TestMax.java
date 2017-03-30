import java.util.Scanner;

/**
 * Created by danny on 15/12/18.
 */
public class TestMax {
    public static void main(String args[]) {
        int i, min, max;
        int A[] = new int[10];
        Scanner input = new Scanner(System.in);
        for (int j = 0; j < 10; j++) {//输入10个数
            System.out.println("请输入一个数字：");
            int length = input.nextInt();//输入一个字符串
            A[j] = length;
        }
        min = max = A[0];
        System.out.print("数组A的元素包括：");
        int j = 0;
        int n = 0;
        for (i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
            if (A[i] > max) { // 判断最大值

                j = i;
                max = A[i];
            }
            if (A[i] < min) {// 判断最小值
                min = A[i];
                n = i;
            }
        }
        System.out.println("\n数组的最大值是：" + max + "数组的位置是：" + (j + 1)); // 输出最大值和最大值的位置
        System.out.println("数组的最小值是：" + min + "数组的位置是：" + (n + 1)); // 输出最小值
    }
}
