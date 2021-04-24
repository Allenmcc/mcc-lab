package leetCode;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {


    public static class ListNode {

        int val;
        ListNode next = null;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //初始节点
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //循环结束 l1 or l2 为null
        cur.next = l1 != null ? l1 : l2;
        //初始节点
        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        // write code here
        ListNode result = new ListNode();
        ListNode curr = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;

        }
        curr.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public static void main(String[] args) {

    }
}
