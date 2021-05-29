package leetCode;

/**
 * 整数翻转
 * https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
 */
public class Reverse7 {

    public static int reverse(int x) {

        int result = 0;
        //不用>0 是考虑到负数
        while (x != 0) {
            int tmp = x % 10;
            //加之前判断
            //Integer.MAX_VALUE = 2147483647  result > 214748364  or  (result == 214748364 && 加的数大于7,7可以）
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            //-8 可以
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
