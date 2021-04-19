package leetCode;


import java.util.Objects;

public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        //第一个字符初始化
        String ans = strs[0];
        for (int i = 1; i <= strs.length - 1; i++) {
            for (int j = 0; j <= ans.length() - 1; j++) {
               //后面字符短了 ab a 这种情况
                if( j > strs[i].length() - 1){
                    ans = strs[0].substring(0, j);
                    break;
                }
                if (strs[i].charAt(j) != ans.charAt(j)) {
                    //不相等，开始更新前缀
                    ans = strs[0].substring(0, j);
                    break;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"dog", "racecar", "car"};
        String[] strs3 = new String[]{"ab", "a"};

        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));

//        System.out.println("abc".substring(0,1));
    }
}
