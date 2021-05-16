package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class FIndMaxN {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList();
        }

        Arrays.sort(input);

        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input,4));
    }
}
