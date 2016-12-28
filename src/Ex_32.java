
/**
 * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 */
public class Ex_32 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        // 首先判断两个链表是否有环
        // 一个有环一个无环肯定不相交
        // 两个无环，判断两个的尾结点是否相等，想等则相交，否则不相交
        // 两个都有环，如果入环点相同则相交，不相等则遍历其中一个环，判断在遍历的过程中是否能遇到另外一个的入环点，遇到则相等，否则不相等
        ListNode node1 = getNode(head1);
        ListNode node2 = getNode(head2);
        if (node1 == null && node2 != null || node1 != null && node2 == null) {//一个有环一个无环
            return false;
        } else if (node1 == null && node2 == null) {//连个都无环
            while (node1.next != null) {
                node1 = node1.next;
            }
            while (node2.next != null) {
                node2 = node2.next;
            }
            return node1 == node2;
        } else {//两个都有环
            if (node1 == node2) {
                return true;
            }
            ListNode flag = node1.next;
            while (node1 != flag) {
                if (flag == node2) {
                    return true;
                }
                flag = flag.next;
            }
        }
        return false;
    }

    //找到链表的入环点，如果存在就返回入环点，否则但会null
    private static ListNode getNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {//快慢指针第一次相遇在环中
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
