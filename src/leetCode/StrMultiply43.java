package leetCode;

/**
 * 字符串大数相乘
 * 时间复杂度：O(M N)。M,NM,N 分别为 num1 和 num2 的长度。
 * 空间复杂度：O(M+N)。用于存储计算结果。
 * https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
 */
public class StrMultiply43 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        String result = multiply(num1,num2);

//        System.out.println(isNumber(num1));
        System.out.println(result);
    }

    /**
     * 计算形式
     * num1
     * x num2
     * ------
     * result
     */
    public static String multiply(String num1, String num2) {
        //校验字符串是否数字
        if (!isNumber(num1) || !isNumber(num2)) {
            return "0";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            //进位信息
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            //j 为num1 从后往前遍历   carry != 0  最高位存在进位
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                //进位信息
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            //进位信息
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    private static boolean isNumber(String str) {
        String reg = "^[0-9]+$";
        //包含小数
//        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
}
