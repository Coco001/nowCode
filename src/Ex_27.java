import java.util.ArrayDeque;

/**
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class Ex_27 {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(2);
        test.next.next.next.next = new ListNode(1);
//        test.next.next.next.next.next = new ListNode(2);
        System.out.println(isPalindrome(test));

    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null) {
            return false;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ListNode slow = pHead;
        ListNode fast = pHead;
        queue.addLast(slow.val);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            queue.addLast(slow.val);
        }
        //判断是偶数链表还是奇数链表
        if (fast.next != null) {//偶数链表
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != queue.pollLast()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
