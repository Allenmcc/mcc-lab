package sort;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public class Bubble {

    private static void sort(int[] nums) {
        for (int i = 0; i <= nums.length - 1; i++) {

            //j+1  所有不能==nums.length - i,取边界值试一下
            for (int j = 0; j < nums.length - i - 1; j++) {

                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }

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
