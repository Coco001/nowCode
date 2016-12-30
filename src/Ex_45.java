import java.util.ArrayDeque;

/**
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
public class Ex_45 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int[] findError(TreeNode root) {
        // write code here
        int[] res = new int[2];
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        TreeNode cur=root;
        TreeNode point=null;//栈顶弹出的元素，是用来比较的第一个元素
        while (!queue.isEmpty() || cur != null) {
            if (cur != null) {
                queue.addLast(cur);
                cur = cur.left;
            } else {
                cur = queue.pollLast();
                if (point != null && point.val > cur.val) {
                    res[1] = res[1] == 0 ? point.val : res[1];
                    res[0] = cur.val;
                }
                point = cur;
                cur = cur.right;
            }
        }
        return res;
    }
}
