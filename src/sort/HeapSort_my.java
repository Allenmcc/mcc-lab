package sort;

public class HeapSort_my {


    private static void sort(int[] sourceArray) {

        int len = sourceArray.length;
        buildMaxHeap(sourceArray, len);

        //交互-堆调整
        for (int i = len - 1; i > 0; i--) {
            swap(sourceArray, 0, i);
            len--;
            //交换后,从堆顶开始调整
            adjust(sourceArray, len, 0);
        }

    }

    private static void buildMaxHeap(int[] sourceArray, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(sourceArray, length, i);
        }


    }


    private static void adjust(int[] sourceArray, int length, int i) {

        int lagest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && sourceArray[lagest] < sourceArray[left]) {
            lagest = left;
        }

        if (right < length && sourceArray[lagest] < sourceArray[right]) {
            lagest = right;
        }

        if (i != lagest) {
            swap(sourceArray, i, lagest);
            adjust(sourceArray, length, lagest);
        }

    }

    private static void swap(int[] sourceArray, int i, int j) {

        int tmp = sourceArray[i];
        sourceArray[i] = sourceArray[j];
        sourceArray[j] = tmp;

    }

    public static void main(String[] args) {
        int[] sourceArray = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        sort(sourceArray);

        for (int i = 0; i < sourceArray.length; i++) {
            System.out.println(sourceArray[i]);
        }

    }
}
