import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串全排列
 * 回溯
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
 */
public class biroTest {

    public static void permutation(char[] buf, int start, int end) {
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        } else {// 多个字母全排列
            for (int i = start; i <= end; i++) {
                char temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;

                permutation(buf, start + 1, end);// 后续元素递归全排列

                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

    static List<String> res = new LinkedList<>();//?
    static char[] c;

    public static void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            //这一层去重 剪枝
            if (set.contains(c[i])) continue;
            set.add(c[i]);

            char tmp = c[i];
            c[i] = c[x];
            c[x] = tmp;
            dfs(x + 1);

            tmp = c[i];
            c[i] = c[x];
            c[x] = tmp;

        }
    }

    public static void main(String arg[]) {

//        char[] buf = new char[] { 'a', 'b', 'c','d'};
        char[] buf = new char[]{'a', 'b', 'a'};
//        permutation(buf, 0, 2);
        c = buf;
        dfs(0);

        System.out.println(res);

    }
}
