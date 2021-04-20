package leetCode;

import java.util.Arrays;

public class FindKth {

    public static int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        return a[n-K];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,2,2};
        int n = 5;
        int k = 3;
        System.out.println(findKth(a,n,k));
    }
}
