
/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 */
public class Ex_29 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public int chkLoop(ListNode head, int adjust) {
        // write code here
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (cur != null) {
            if (fast.next == null || fast.next.next == null) {
                return -1;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {//快慢指针第一次相遇在环中
                break;
            }
            cur = cur.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast.val;
    }
}
