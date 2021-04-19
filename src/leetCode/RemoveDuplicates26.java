package leetCode;

import java.util.Arrays;

/**
 *
 * 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
 *
 */
public class RemoveDuplicates26 {

    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        //后面指针作为边际，因为前面可能达不到最后
        for (; j <= nums.length - 1; ) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 2};
        int[] nums2 = new int[]{1, 1, 2, 3};

        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates(nums2));

    }
}
