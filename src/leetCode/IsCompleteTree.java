package leetCode;

import java.util.LinkedList;

/**
 * 完全二叉树，层次遍历遇到第一个空节点后，剩余节点还有非空，则一定不是.巧用continue并配合标志位。
 * @param 
 * @return
 */
public class IsCompleteTree {


   
    public static boolean isCompleteTree(LevelOrder102.TreeNode root) {
        if(root==null){
            return true;
        }
        LinkedList<LevelOrder102.TreeNode> queue=new LinkedList<>();
        queue.add(root);
        LevelOrder102.TreeNode cur;
        boolean notComplete=false;
        while (!queue.isEmpty()){
            cur=queue.remove();
            if(cur==null){
                notComplete=true;
                //第一个空节点之后的节点，countinue使用的很妙
                continue;
            }
            if(notComplete){
                return false;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return true;

    }

    public static void main(String[] args) {

        LevelOrder102.TreeNode p4 = new LevelOrder102.TreeNode(4, null, null);
        LevelOrder102.TreeNode p5 = new LevelOrder102.TreeNode(5, null, null);
        LevelOrder102.TreeNode p2 = new LevelOrder102.TreeNode(2, null, p4);
        LevelOrder102.TreeNode p3 = new LevelOrder102.TreeNode(3, p5, null);
        LevelOrder102.TreeNode p1 = new LevelOrder102.TreeNode(1, p2, p3);
        
        System.out.println(isCompleteTree(p1));

    }
}
