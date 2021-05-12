package dfs;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chunchen.meng on 2019/2/19.
 */

/**
 * 深度遍历
 * 给一个数组和目标值，求数组中和为目标值的所有组合，1.数组中每个值可以重复使用2.不允许重复。
 * https://blog.csdn.net/Somnus_k/article/details/82054645
 */
public class ArraySum {

    public static void main(String[] args) {
        ArraySum solution =  new ArraySum();
        int arr[] = {2,6,3,7};
        System.out.println(solution.combinationSum(arr,9));
    }


    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum(int[] arr, Integer target) {

        //入参判断
        if (null == arr || arr.length == 0) {
            return list;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        //必要的
        Arrays.sort(arr);
        dfs(arr, 0, target, arrayList);
        return list;

    }

    private void dfs(int[] arr, int index, int sum, ArrayList<Integer> arrayList) {

        if (sum < 0) {
            return;
        }
        if (sum == 0 && !list.contains(arrayList)) {
            //new 对象，直接添加是引用，值会变
//            list.add(arrayList);
            list.add(new ArrayList<Integer>(arrayList));
            return;
        }

        //i = index 下一次遍历从排序后的当前元素开始（允许重复）
        for (int i = index; i < arr.length; i++) {
            //加入一个元素
            arrayList.add(arr[i]);
            //递归 (允许重复)  递归参数要思考清楚（开始坐标、目标总和）
            dfs(arr, i, sum - arr[i], arrayList);
            //(不允许重复)
//            dfs(arr, i+1, sum - arr[i], arrayList);
            //出口返回后删除最后一个继续遍历,即回到上一层
            arrayList.remove(arrayList.size() - 1);

        }

    }

}
