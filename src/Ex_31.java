/**
 * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 *
 */
public class Ex_31 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        //首先求出两个链表的入环点
        ListNode node1 = getNode(head1);
        ListNode node2 = getNode(head2);
        if (node1 == node2) {//如果入环点相同则相交
            return true;
        }
        ListNode flag = node1.next;
        while (node1 != flag) {//否则对其中一个的入环点进行遍历，遍历过程中遇到另一个入环点则相交，否则不相交
            if (flag == node2) {
                return true;
            }
            flag = flag.next;
        }
        return false;
    }
    //获取链表的入环节点
    private static ListNode getNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (cur != null) {
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
        return fast;
    }
}
