import java.util.Stack;

/**
 * 对栈进行逆序操作
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 */
public class Ex_17 {

    public static void main(String[] args) {
        int[] test = new int[]{4, 3, 2, 1};
        reverseStack(test, 4);
    }

    public static int[] reverseStack(int[] A, int n) {
        // write code here
        if (A == null || n < 1) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = n-1; i >=0; i--) {
            stack.push(A[i]);
        }
        reverse(stack);
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
    //移除栈底元素
    private static int get(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = get(stack);
            stack.push(result);
            return last;
        }
    }
    //逆序栈中元素
    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = get(stack);
        reverse(stack);
        stack.push(i);
    }
}
