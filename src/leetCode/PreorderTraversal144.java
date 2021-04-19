package leetCode;


//class TreeNode1 {
//      int val;
//      TreeNode1 left;
//      TreeNode1 right;
//      TreeNode1() {}
//      TreeNode1(int val) { this.val = val; }
//      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreorderTraversal144 {


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preList = new ArrayList<>();
        //  preList引用传递
        preorder(root, preList);
        return preList;
    }

    public void preorder(TreeNode root, List<Integer> preList) {

        if (root == null) {
            return;
        }
        preList.add(root.val);
        preorder(root.left, preList);
        preorder(root.right, preList);

    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        head.val = 1;
        node2.val = 2;
        node3.val = 3;
        head.left = node2;
        head.right = node3;

        PreorderTraversal144 preorderTraversal144 = new PreorderTraversal144();
        List<Integer> result = preorderTraversal144.preorderTraversal(head);
        System.out.println(result);

        List<Integer> test = Lists.newArrayList(1,2,3);
        tesList(test);
        System.out.println(test);

    }

    public static void tesList(List<Integer> list){

        list.add(232);

    }
}
