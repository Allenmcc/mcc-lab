package leetCode;

public class KList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode FindKthToTail(ListNode head, int k) {
        if (null == head) {
            return head;
        }
        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        if (length < k) {
            return null;
        }
        int target = length - k;
        while (target > 0) {
            head = head.next;
            target--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = FindKthToTail(node, 1);
        System.out.println(1);
    }
}
