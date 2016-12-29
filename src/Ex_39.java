import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 请用递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class Ex_39 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private LinkedList<Integer> list = new LinkedList<>();
    public int[][] convert(TreeNode root) {
        // write code here
        int[][] res = new int[3][];
        func1(root);
        int[] temp1 = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            temp1[index++] = i;
        }
        res[0] = temp1;
        list.clear();

        func2(root);
        int[] temp2 = new int[list.size()];
        index = 0;
        for (Integer i : list) {
            temp2[index++] = i;
        }
        res[1] = temp2;
        list.clear();

        func3(root);
        int[] temp3 = new int[list.size()];
        index = 0;
        for (Integer i : list) {
            temp3[index++] = i;
        }
        res[2] = temp3;
        return res;
    }

    private void func1(TreeNode node) {
        if (node == null) {
            return ;
        }
        list.add(node.val);
        func1(node.left);
        func1(node.right);
    }
    private void func2(TreeNode node) {
        if (node == null) {
            return ;
        }
        func2(node.left);
        list.add(node.val);
        func2(node.right);
    }
    private void func3(TreeNode node) {
        if (node == null) {
            return ;
        }
        func3(node.left);
        func3(node.right);
        list.add(node.val);
    }
}
