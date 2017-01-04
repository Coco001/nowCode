/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 */
public class Ex_22 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
        if (A.length == 0) {
            ListNode head = new ListNode(val);
            head.next = head;
            return head;
        }
        ListNode head = new ListNode(A[0]);
        ListNode r = head;
        ListNode p;
        for (int i = 0; i < A.length - 1; i++) {
            p = new ListNode(A[nxt[i]]);
            r.next = p;
            r = p;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (pre.val <= val && cur.val >= val) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        ListNode ins = new ListNode(val);
        ins.next = cur;
        pre.next = ins;

        return val < head.val ? ins : head;
    }
    /**
     * public ListNode insert(int[] A, int[] nxt, int val) {
     // write code here
     if(A.length==0){
     return new ListNode(val);
     }
     ListNode head = new ListNode(A[0]);
     ListNode r = head;
     ListNode p;
     for(int i=0;i<A.length-1;i++){
     p = new ListNode(A[nxt[i]]);
     r.next = p;
     r = p;
     }
     ListNode pre = head;
     ListNode cur = pre.next;
     while(cur != null){
     if(pre.val <= val && cur.val >= val)
     break;
     pre = cur;
     cur = cur.next;
     }
     ListNode ins = new ListNode(val);
     ins.next = cur;
     pre.next = ins;

     return val < head.val ? ins : head;
     }
     */
}
