package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 */
public class ThreeSum15 {

    public static List<List<Integer>> treeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i <= length - 1; i++) {
            if (nums[i] > 0) break;  //// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                //首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，
                //数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 00，满足则添加进结果集
                int sum = nums[i] + nums[L] + nums[R];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //重复跳过
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }

        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -1};
        int[] nums2 = new int[]{};
        int[] nums3 = new int[]{0};
        System.out.println(treeSum(nums));
        System.out.println(treeSum(nums2));
        System.out.println(treeSum(nums3));

    }
}
