/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，
 * 使得小于等于这个值的结点移到前面，大于该值的结点在后面，
 * 同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，
 * 使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 */
public class Ex_23 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);

        ListNode sh = small;
        ListNode bh = big;
        while (head != null) {
            int cmp = head.val;
            if (cmp > val) {
                bh.next = new ListNode(cmp);
                bh = bh.next;
            } else {
                sh.next = new ListNode(cmp);
                sh = sh.next;
            }
            head = head.next;
        }

        if (small.next == null) {
            return big.next;
        } else if (big.next == null) {
            return small.next;
        } else {
            sh.next = big.next;
            return small.next;
        }
    }
}
