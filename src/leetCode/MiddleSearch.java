package leetCode;

public class MiddleSearch {

    public static int search(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                //重复的取第一个
                index = middle;
                right = middle -1;

            }else if (nums[middle] > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        return index;

    }

    public static int search2 (int[] nums, int target) {
        // write code here
        int index = -1;
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] == target) {
                // 在low 到 mid之间找第一个下标
                index = mid;
                high = mid-1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int re = search(nums, 1);
//        int re2 = search2(nums, 1);
        System.out.println(re);
//        System.out.println(re2);
    }
}
