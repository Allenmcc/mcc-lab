import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by danny on 2016/10/28.
 */
public class SerializeTree {

    public static class TreeNode{
        public int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }


    }

    public static void serialize(TreeNode root, PrintStream ps){
        if(null == root){
            ps.print("# ");
        }
        else {
            ps.print(root.val+" ");
            serialize(root.left,ps);
            serialize(root.right,ps);
        }

    }

    public static TreeNode deSerialize(Scanner cin){

        String token = cin.next();
        if(token.equals("#")){
            return null;
        }else {
            int val = Integer.valueOf(token);
            TreeNode root = new TreeNode(val);
            root.left = deSerialize(cin);
            root.right = deSerialize(cin);

            return root;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        PrintStream ps = new PrintStream(new File("test"));
        serialize(root,ps);
        Scanner cin = new Scanner(new File("test"));
        TreeNode treeNode =  deSerialize(cin);
        System.out.print(treeNode.val);

    }

}
