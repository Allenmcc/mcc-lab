package sort;

/**
 * Created by danny on 2016/10/29.
 * 堆排序 (大根堆，根节点大)
 * https://chihminh.github.io/2016/08/08/heap-sort/
 * https://www.cnblogs.com/chengxiao/p/6129630.html (图解)
 * https://www.runoob.com/w3cnote/heap-sort.html
 *
 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 *
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 *
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
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


    //第一步:构建最大堆
    private static void buildMaxHeap(int nums[]){
        int len = nums.length;
        //非叶子根节点开始,往上遍历
        for (int i = nums.length / 2 -1; i >= 0; i--) {
            adjust(i, len -1, nums);

        }

    }


    public static void main(String args[]) {
        int nums[] = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        int len = nums.length - 1 ;

        buildMaxHeap(nums);

        for (int j = len; j > 0; j--) {
            //堆顶元素放最后
            int tmp = nums[0];
            nums[0] = nums[j];
            nums[j] = tmp;
            len--;
            //放完之后做调整
            adjust(0, len, nums);

        }
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
