package leetCode;

import com.graphbuilder.struc.Stack;

/**
 * 青蛙跳 简单递归
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=117&tqId=37764&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 */
public class FlogJumpN {

    public int jumpFloor(int target) {

        if(target == 0){
            return 0;
        }else if(target ==1){   //还剩1级，只能跳有一种方案
            return 1;
        }else if(target ==2){  //还剩2级，有两种方案
            return 2;
        }
        //f(n) = f(n-1)+f(n-2);  两种方案相加
        return  jumpFloor(target -1) + jumpFloor(target-2);

    }

}
