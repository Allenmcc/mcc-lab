package leetCode;

/**
 * 二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class IsValidBST98 {

    //[-2147483648] 不可以
//    public static int pre = Integer.MIN_VALUE;
    public static long pre = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {

        //出口
        if (root == null) {
            return true;
        }

        //错误 如果下层返回，下面当层逻辑还要接着往后计算，不应该返回
//        if (isValidBST(root.left)) {
//            return true;
//        }

        //非搜索树，直接返回，是的话，接着看右子树
        if (!isValidBST(root.left)) {
            return false;
        }

        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        //[2,2,2] 不是
        if (pre >= root.val) {
            return false;
        }

        pre = root.val;
        return isValidBST(root.right);

    }

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode();
//        n1.val = 2;
//        TreeNode n2 = new TreeNode();
//        n2.val = 1;
//        TreeNode n3 = new TreeNode();
//        n3.val = 3;
//        n1.left = n2;
//        n1.right = n3;
//        boolean result = isValidBST(n1);
//        System.out.println(result);

        TreeNode n1 = new TreeNode();
        n1.val = 5;
        TreeNode n2 = new TreeNode();
        n2.val = 1;
        TreeNode n3 = new TreeNode();
        n3.val = 4;
        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode();
        n4.val = 3;
        TreeNode n5 = new TreeNode();
        n5.val = 6;
        n3.left = n4;
        n3.right = n5;
        boolean result = isValidBST(n1);
        System.out.println(result);
    }

}

