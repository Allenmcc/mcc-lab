package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNumOffer28 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3};
        System.out.println(moreThanHalfNum(array));

    }

    public static int moreThanHalfNum(int[] array) {

        Map<Integer, Integer> map = new HashMap();
        for (int tmp : array) {
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        for (int tmp : array) {
            if (map.get(tmp) > array.length / 2) return tmp;
        }

        return 0;
    }
}
