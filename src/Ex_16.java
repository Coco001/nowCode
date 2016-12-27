import java.util.*;

/**
 * 可查询最值的栈
 */
public class Ex_16 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if (minStack.size() == 0) {
            minStack.push(node);
        } else {
            if (node > minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(node);
            }
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
