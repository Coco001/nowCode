import java.util.Stack;

/**
 * 双栈实现队列
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，
 * 保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 */
public class Ex_18 {
    public int[] towStack(int[] ope, int n) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        int popNum = 0;
        for (int i = 0; i < n; i++) {
            if (ope[i] == 0) {
                popNum++;
            } else {
                stack.push(ope[i]);
            }
        }
        int[] res = new int[popNum];
        while (!stack.isEmpty()) {
            help.push(stack.pop());
        }
        int idx = 0;
        while (popNum-- > 0) {
            res[idx++] = help.pop();
        }
        return res;
    }
}
