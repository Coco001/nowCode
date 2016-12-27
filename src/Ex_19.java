import java.util.*;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class Ex_19 {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        twoStacksSort(test);
    }
    private static ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        if (numbers == null) {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        for (int i = numbers.length-1; i >=0; i--) {
            stack.push(numbers[i]);
        }
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (help.isEmpty()) {//为空直接添加
                help.push(temp);
            } else {//不为空
                if (help.peek() <= temp) {
                    help.push(temp);
                } else {
                    while (!help.isEmpty() && help.peek() > temp) {
                        stack.push(help.pop());
                    }
                    help.push(temp);
                }
            }
        }
        while (!help.isEmpty()) {
            res.add(help.pop());
        }
        return res;
    }
}
