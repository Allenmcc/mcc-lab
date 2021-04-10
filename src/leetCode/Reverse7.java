package leetCode;

/**
 * 整数翻转
 * https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
 */
public class Reverse7 {

    public static int reverse(int x) {

        int result = 0;
        while (x != 0) {
            int tmp = x % 10;
            //加之前判断
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }
            result = result * 10 + tmp;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(901000));
        System.out.println(reverse(1534236469));
    }

}
