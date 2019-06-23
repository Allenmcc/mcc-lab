package sort;

/**
 * Created by chunchen.meng on 2019/6/21.
 * https://segmentfault.com/a/1190000013814458
 * https://www.cnblogs.com/xiaoming0601/p/5862793.html
 */
public class insert {

    //每次都需要交换的，直接找下标没有用。
    private static void sort(int[] nums) {
        //从第二个开始
        for (int i = 1; i <= nums.length -1; i++) {

            int tmp = nums [i];
            int j = i;
            while ( j > 0 && nums[j -1 ] > tmp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    private static void insertSortArray ( int arr[])
    {

        int i, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++) {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }

    }

    public static void main(String[] args) {
        int []nums = {87, 45, 78, 32, 17, 65, 53, 9, 122};
//        sort(nums);
        insertSortArray(nums);
        for (int a:nums) {
            System.out.print(a + " ");
        }
    }
}
