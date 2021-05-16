package leetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMinKth {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        int len = input.length;
        creatBigHeap(input, k);//建立大根堆
        for (int i = k; i < len; i++) {
            if (input[i] < input[0]) {
                int tmp = input[i];
                input[k] = input[0];
                input[0] = tmp;
                ajustDown(input, 1, k);
            }
        }

        for (int j = 0; j < k; j++) {
            list.add(input[j]);
        }
        return list;
    }

    public int[] creatBigHeap(int[] A, int len) {
        for (int i = A.length / 2; i > 0; i--) {
            ajustDown(A, i, len);
        }
        return A;
    }

    private void ajustDown(int[] a, int i, int length) {//用递归的方法向下调整
        if (i * 2 <= length) {
            int tmp = a[i * 2 - 1];
            if (a[i - 1] < a[i * 2 - 1]) {
                if (i * 2 + 1 <= length && a[i * 2 - 1] < a[i * 2]) {
                    tmp = a[i * 2];
                    a[i * 2] = a[i - 1];
                    a[i - 1] = tmp;
                    ajustDown(a, i * 2 + 1, length);
                } else {
                    a[i * 2 - 1] = a[i - 1];
                    a[i - 1] = tmp;
                    ajustDown(a, i * 2, length);
                }
            } else {
                if (i * 2 + 1 <= length && a[i - 1] < a[i * 2]) {
                    tmp = a[i * 2];
                    a[i * 2] = a[i - 1];
                    a[i - 1] = tmp;
                    ajustDown(a, i * 2 + 1, length);
                }
            }

        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,2,2};
//        int n = 5;
        int k = 3;
//       GetLeastNumbers_Solution(a,k);
    }
}
