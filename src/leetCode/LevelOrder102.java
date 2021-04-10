package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            //遍历长度未当前的队列长度(添加子节点之前)
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;


    }

    public static void main(String[] args) {

        TreeNode p4 = new TreeNode(4, null, null);
        TreeNode p5 = new TreeNode(5, null, null);
        TreeNode p2 = new TreeNode(2, null, p4);
        TreeNode p3 = new TreeNode(3, p5, null);
        TreeNode p1 = new TreeNode(1, p2, p3);

//        System.out.println(levelOrder(p1));
        System.out.println(levelOrderOfMy(p1));

    }

    public static List<List<Integer>> levelOrderOfMy(TreeNode root) {

        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {

            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.remove();
                if(null != tmp.left){
                    queue.add(tmp.left);
                }
                if(null != tmp.right){
                    queue.add(tmp.right);
                }
                levelList.add(tmp.val);
            }
            result.add(levelList);

        }

        return result;

    }
}
