/**
 * Created by danny on 2016/10/16.
 */

class BTree {
    char data;
    BTree left;
    BTree right;
}

public class NodeTree {

    //s1先序第一个字符位置，s2中序第一个字符位置；l1先序列最后一个字符的位置，l2中序列最后一个字符的位置
    public void Create(BTree root, String first, String mid, int s1, int l1, int s2, int l2) {
        root.data = first.charAt(s1);                  //根节点为先序的第一个字符
        int rootpos = mid.indexOf(first.charAt(s1));   //先序第一个字符在中序中的位置
        int len = rootpos - s2;                        //被截取的字符串长度(不包括根)
        if (rootpos > s2) {         //根位置在中序首字符之后
            root.left = new BTree();
            Create(root.left, first, mid, s1 + 1, s1 + len, s2, rootpos - 1);
        }
        if (rootpos < l2) {         //根在中序结尾之前
            root.right = new BTree();
            Create(root.right, first, mid, s1 + len + 1, l1, rootpos + 1, l2);

        }
    }

    public void show(BTree root) {
        if (root.left != null) {
            show(root.left);
        }
        if (root.right != null) {
            show(root.right);
        }
        System.out.print(root.data);
    }

    public static void main(String[] args) {
        String first = "ABDGCEFH";
        String mid = "DGBAECHF";
        NodeTree nodeTree = new NodeTree();
        BTree root = new BTree();
        nodeTree.Create(root, first, mid, 0, first.length() - 1, 0, mid.length() - 1);
        nodeTree.show(root);
    }

}