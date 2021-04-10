package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 * 滑动窗口
 */
public class LengthOfLongestSubstring3 {

    private static Integer longestStr(String s) {

        int n = s.length(), ans = 0;
        //定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            //随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，
            // 此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
            if (map.containsKey(alpha)) {
//                start = Math.max(map.get(alpha), start);
                start = map.get(alpha);
            }
            //无论是否更新 start，都会更新其 map 数据结构和结果 ans。
            map.put(s.charAt(end), end + 1);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;

    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "pwwkew";
        String s3 = "abba";
//        Integer len = longestStr(s);
//        System.out.println(len);
//        System.out.println(lengthOfMy(s2));
        System.out.println(lengthOfMy(s3));
    }

    public static Integer lengthOfMy(String str) {

        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < str.length(); end++) {
            Character c = str.charAt(end);
            //存在,start 重新获取
            if(map.containsKey(c)){
//                start = map.get(c);
                //需要的,abba 这种情况,到第二个a的时候,如果只取map.get(c),那只能取第一个a的value=1 作为start,不符合预期.
                start = Math.max(map.get(c),start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(c, end + 1);
        }
        return ans;

    }

}
