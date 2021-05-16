package leetCode;

/**
 * 相同的树
 * 深度优先遍历
 * https://leetcode-cn.com/problems/same-tree/solution/hua-jie-suan-fa-100-xiang-tong-de-shu-by-guanpengc/
 */
public class IsSameTree100 {

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //当两棵树的当前节点都为 null 时返回 true
        if (p == null && q == null) {
            return true;
        }
        //已经至少一个不为null
        //当其中一个为 null 另一个不为 null 时返回 false
        if (p == null || q == null) {
            return false;
        }
        //当两个都不为空但是值不相等时，返回 false
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        TreeNode p2 = new TreeNode(2, null, null);
        TreeNode p3 = new TreeNode(3, null, null);
        TreeNode p1 = new TreeNode(1, p2, p3);

        TreeNode q2 = new TreeNode(2, null, null);
        TreeNode q3 = new TreeNode(3, null, null);
        TreeNode q1 = new TreeNode(1, q2, q3);

        System.out.println(isSameTree(p1,q1));

        TreeNode p22 = new TreeNode(2, null, null);
        TreeNode p21 = new TreeNode(1, p22, null);

        TreeNode q23 = new TreeNode(3, null, null);
        TreeNode q21 = new TreeNode(1, null, q23);

        System.out.println(isSameTree(p21, q21));

    }
}
