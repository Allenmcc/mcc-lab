package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chunchen.meng on 2019/7/25.
 * 无序数组中，一个数字出现的频率超过了其他数字出现的频率和，求这个数字。
 */
public class MoreThanHalf {
    // 无序数组，有个数字出现的频率超过其他频率之和，求这个数
    public static void main(String[] args) {

        int[] array = { 4, 1, 4, 1, 1, 1, 2, 1, 1, 4 };
        int[] array2 = { 5, 4, 2, 2, 3, 1, 2, 2, 2, 2 };
        int[] a3 = { 1, 2, 3, 4, 3, 6, 3, 3, 3, 3 };
        System.out.println(":" + MoreThanHalf.findMaxFNumone(array) + ":" + MoreThanHalf.findMaxFNumone(array2) + ":"
                + MoreThanHalf.findMaxFNumone(a3));
        System.out.println(
                ":" + findMaxFNumTwo(array) + ":" + findMaxFNumTwo(array2) + ":" + MoreThanHalf.findMaxFNumTwo(a3));
        System.out.println(":" + findMaxFNumThree(array) + ":" + findMaxFNumThree(array2) + ":" + findMaxFNumThree(a3));

    }

    // 先排序，再找中间的数字。因为出现频率最多，有序后是一定落在中间上。
    public static int findMaxFNumone(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        // System.out.println(JSON.toJSON(array));
        int count = 0;
        int num = (array.length / 2);
        // System.out.println(num);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[num]) {
                count++;
            }

        }

        if (count > (array.length / 2)) {
            return array[num];
        }
        return 0;

    }

    // 利用map。
    public static int findMaxFNumTwo(int[] array) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (m.containsKey(array[i])) {
                int tmp = m.get(array[i]);
                tmp++;
                m.put(array[i], tmp);
                if (tmp > array.length / 2) {
                    return array[i];
                }
            } else {
                m.put(array[i], 1);
            }

        }
        return 0;

    }

    /**
     * 则是利用数组特点，因为要求的数字多于数组的一半，则每遇到一个数字，若和之前相同则加1，
     * 若不同则减1，若为0则换一个数字，最后剩下的即为要求的数字
     *
     * @param array
     * @return
     */
    public static int findMaxFNumThree(int[] array) {
        int result = array[0];
        int times = 1;
        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                // System.out.println("i="+i);
            }
            if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }

        System.out.println("num=" + result);

        return result;

    }
}
