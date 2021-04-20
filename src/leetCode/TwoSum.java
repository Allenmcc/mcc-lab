package leetCode;

/**
 * 两数之和
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int result = one + nums[j];
                if (result == target) {
                    results[0] = i;
                    results[1] = j;
                }
            }

        }
        return results;
    }

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int[] nums = {3,3};
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] results = twoSum(nums, target);
        System.out.println(results[0] + ";" + results[1]);
    }
}
