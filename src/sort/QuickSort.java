package sort;

/**
 * Created by danny on 2016/10/31.
 */
public class QuickSort {


    public static void quickSort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x)
                    j--;
                if (i < j)
                    s[i++] = s[j];
                while (i < j && s[i] < x)
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }
}