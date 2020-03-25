package sort;


/**
 * Created by chunchen.meng on 2019/6/18.
 * 大根堆
 */
public class HeapSort2 {


    //
    private static int[] sort(int[] arr){
        int len = arr.length;

        //构建大根堆
        buildMaxHeap(arr, len);

        //交换-堆调整
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            //交换之后的堆调整，从当前0节点开始
            adjustHeap(arr, 0, len);
        }
        return arr;
    }

    //构建大根堆，非叶子根节点开始，只需一次
    private static void buildMaxHeap(int[] arr, int len) {
      //从0开始 i = len / 2 -1
        for (int i = len / 2 -1 ; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
    }


    //堆调整，i起点，len长度
    private static void adjustHeap(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        //3个节点找最大的
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        //交换完之后子节点不满足最大堆，重新调整。子节点最大根开始
        if (largest != i) {
            swap(arr, i, largest);
            adjustHeap(arr, largest, len);
        }
    }

    //元素交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] sourceArray = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        sort(sourceArray);

        for(int i:sourceArray){
            System.out.print(i+" ");
        }



    }
}
