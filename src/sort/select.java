package sort;

/**
 * Created by chunchen.meng on 2019/6/21.
 * https://segmentfault.com/a/1190000013814458
 */
public class select {

    private static void sort(int[] nums) {
        for (int i = 0; i <= nums.length - 2; i++) {
            int min = i;
            // 找到每趟最小的下标
            for (int j = i+1; j <= nums.length - 1; j++) {
                if(nums[min] > nums[j]){
                    min = j;
                }

            }
            //交换
            if(min != i){
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;




            }

        }
    }

    public static void main(String[] args) {
        int []nums = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        sort(nums);
        for (int a:nums) {
            System.out.print(a + " ");
        }
    }
}
