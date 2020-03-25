package sort;

/**
 * Created by danny on 2016/10/29.
 * 堆排序 (大根堆，根节点大)
 * https://chihminh.github.io/2016/08/08/heap-sort/
 * https://www.cnblogs.com/chengxiao/p/6129630.html (图解)
 * https://www.runoob.com/w3cnote/heap-sort.html
 */
public class HeapSort {

    //堆调整
    private static void adjust(int i, int len, int nums[]) {

        //与当前左右子节点比较
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int p = i;
        if (left <= len && nums[left] > nums[p])
            p = left;
        if (right <= len && nums[right] > nums[p])
            p = right;

        if (p != i) {
            int tmp = nums[p];
            nums[p] = nums[i];
            nums[i] = tmp;
            //交换完之后子节点不满足最大堆，重新调整，p为子节点最大根
            adjust(p, len, nums);

        }

    }


    //构建最大堆
    private static void buildMaxHeap(int nums[]){
        int len = nums.length;
        //非叶子根节点开始
        for (int i = nums.length / 2 -1; i >= 0; i--) {
            adjust(i, len -1, nums);

        }

    }


    public static void main(String args[]) {
        int nums[] = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        int len = nums.length - 1 ;

        buildMaxHeap(nums);

        for (int j = len; j > 0; j--) {
            int tmp = nums[0];
            nums[0] = nums[j];
            nums[j] = tmp;
            len--;
            adjust(0, len, nums);

        }
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
