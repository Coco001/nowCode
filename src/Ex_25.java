/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，
 * 如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */
public class Ex_25 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode inverse(ListNode head, int k) {
        // write code here
        if (k < 2) {
            return head;
        }
        ListNode cur = head;//翻转结点的末尾
        ListNode start;//翻转结点的头
        ListNode pre = null;//翻转结点头的前一个结点
        ListNode next;//翻转结点的末尾的下一个结点
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;//翻转之后的头
                resign(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    /**
     * @param left  翻转结点头的前一个节点
     * @param start 翻转结点的头节点
     * @param end   翻转结点的尾结点
     * @param right 翻转结点尾结点的下一个结点
     */
    private void resign(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next;
        while (cur != right) {//修改指针的方法不是尾插法
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {//连接首
            left.next = end;
        }
        start.next = right;//连接尾
    }
}
