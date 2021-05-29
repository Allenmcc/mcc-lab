package leetCode;

/**
 * 最长回文子串
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abc"));
        System.out.println(longestPalindromeOfMy("aaaa"));
    }


    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        //两层遍历 abcd
        for (int i = 0; i < len; i++)
            //ab   abc  abcd
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }


    public static String longestPalindromeOfMy(String s) {
        int max = 0;
        String str = "";
        int length = s.length();
        for(int i =0;i <length;i++){
            //j<=length  等于 substring 可以到长度后一位不越界
            for(int j=i+1;j<=length;j++){
                String tmp = s.substring(i,j);
                if(isPalindromic(tmp)){
                    int tmpSize = tmp.length();
                    if(tmpSize >max){
                        max = tmpSize;
                        str = tmp;
                    }
                }
            }
        }
        return str;
    }
}
