package sort;

/**
 * Created by chunchen.meng on 2019/6/21.
 */
public class BubbleOptimize {


    private static void sort(int[] nums) {

        //记录交换了几趟
        int num = 0;
        for (int i = 0; i <= nums.length - 1; i++) {

            //每趟是否发生交换
            int isChange= 0 ;

            //j+1  所有不能==nums.length - i - 1
            for (int j = 0; j < nums.length - i - 1; j++) {

                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    isChange = 1;
                }

            }
            if(isChange == 0){
                System.out.println(num);
                break;
            }
            num ++;

        }
    }

    public static void main(String[] args) {
//        int []nums = {87, 45, 78, 32, 17, 65, 53, 9, 122};
        int []nums = {2, 5, 1 ,3, 4};
        sort(nums);
        for (int a:nums) {
            System.out.print(a + " ");
        }
    }
}
