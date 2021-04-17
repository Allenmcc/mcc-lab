package leetCode;

import java.util.Stack;

/**
 * 42. 接雨水
 * 使用单调栈
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/trapping-rain-water-by-ikaruga/
 */
public class Trap42 {

    public static int trap(int[] height) {

        int res = 0;
        //栈存放数组下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            //peek() 返回栈顶原始但不移除
            //当出现高于栈顶的柱子时,说明可以对前面的柱子结算了,计算已经到手的雨水，然后出栈前面更低的柱子
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                //当前栈顶元素
                int curr = stack.peek();
                //出栈
                stack.pop();
                //1,2 这种,左边没有高的,接不住
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int right = i;
                //1,0,3 -> 高度差
                int h = Math.min(height[left], height[right]) - height[curr];
                //宽
                res += (right - left - 1) * h;
            }
            //入栈
            stack.push(i);
        }
        return res;

    }


    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
        System.out.println(trap(height2));
    }
}
