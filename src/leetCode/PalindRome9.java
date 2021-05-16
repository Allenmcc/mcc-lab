package leetCode;

/**
 * 9. 回文数
 * 字符串
 */
public class PalindRome9 {

    public static boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        char[] a2 = s.toCharArray();
        for (int i = 0; i < a2.length/2; i++) {
            if (a2[i] != a2[a2.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-10));
        System.out.println(isPalindrome(121));
    }
}
