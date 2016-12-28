/**
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，
 * 请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * 给定两个链表的头结点headA和headB，请返回一个bool值，
 * 代表这两个链表是否相交。保证两个链表长度小于等于500。
 *
 * 注意：链表相交指的是地址相同，不是链表中的值相同
 */
public class Ex_30 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        // write code here
        while (headA.next != null) {
            headA = headA.next;
        }
        while (headB.next != null) {
            headB = headB.next;
        }
        return headA == headB;
    }
}
