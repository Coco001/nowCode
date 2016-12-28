/**
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，
 * 保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 */
public class Ex_26 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode clear(ListNode head, int val) {
        // write code here
        ListNode pre = head;//前一个节点
        ListNode cur = head;//当前结点
        while (cur != null) {
            if (cur.val == val) {//需要剔除的点
                //需要判断是否为头节点
                if (cur == head) {//如果是头节点
                    cur = cur.next;
                    head = cur;
                } else if (cur.next != null) {//判断剔除的点是不是尾结点
                    cur = cur.next;
                    pre.next = cur;
                } else {//是尾结点
                    pre.next = null;
                    break;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
