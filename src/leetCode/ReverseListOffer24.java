package leetCode;

/**
 *
 */

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ReverseListOffer24 {

//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }


    public static ListNode reverseList(ListNode head) {

        ListNode p = head ;  //前面的节点
        ListNode q = null;   //后面的节点
        while (p != null){
            ListNode tmp = p.next;  // 暂存后继节点 p.next
            p.next = q;   // 修改 next 引用指向
            q = p;    //后面指向当前
            p = tmp;  //前面指向暂存的tmp
        }
        return q;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head2  =  reverseList(head);
        System.out.println(head2.val);

    }
}
