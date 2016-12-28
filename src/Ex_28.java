
/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */
public class Ex_28 {
    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    private RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        //举例：1->2->3->null
        RandomListNode cur = pHead;
        RandomListNode next;
        //首先遍历链表。在每一个结点之后插入一个新节点（该结点为前一个结点的赋值）
        while (cur != null) {
            next = cur.next;//保存当前结点的下一个结点
            cur.next = new RandomListNode(cur.label);//对当前结点的复制
            cur.next.next = next;//复制的结点指向当前结点的下一个结点
            cur = next;//当前结点移动到下一个需要被复制的结点
        }
        //至此，结点复制完成:1->1->2->2->3->3->null
        //然后定义两个指针，一个指向之前的结点，一个指向复制的结点,复制random指针
        cur = pHead;//指向被复制的节点
        RandomListNode curCopy;//指向复制的结点
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        //最后,进行切割，得到复制的链表
        RandomListNode res = pHead.next;
        cur = pHead;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
