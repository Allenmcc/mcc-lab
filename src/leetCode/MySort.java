package leetCode;

/**
 * 冒泡排序
 */
public class MySort {

    public int[] mySort(int[] arr) {

        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = 0; j <= arr.length - i - 2; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 1, 4,3};
        MySort mySort = new MySort();
        mySort.mySort(arr);
        System.out.println(arr);
    }
}
