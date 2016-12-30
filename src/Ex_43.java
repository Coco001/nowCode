import java.util.ArrayDeque;

/**
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。
 * 树的结点个数小于等于500。
 */
public class Ex_43 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1、采用按层遍历二叉树，从每层的左边向右边一次遍历所有的结点
     * 2、如果当前结点有右孩子，但是没有左孩子，直接返回false
     * 3、如果当前结点并不是左右孩子全有，那之后的结点必须都为叶结点，否则返回false
     * 4、遍历过程中如果不返回false，遍历结束后返回true即可
     */
    public boolean chk(TreeNode root) {
        // write code here
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        TreeNode node;
        boolean flag = false;
        while (!queue.isEmpty()) {
            node = queue.pollFirst();
            if (node.right != null && node.left == null) {
                return false;
            }
            if (flag && (node.left != null || node.right != null)) {//当前结点并不是左右孩子全有，那之后的结点必须都为叶结点，否则返回false
                return false;
            }
            if (node.left != null) {
                queue.addLast(node.left);
            } else {//记录标记，之后的结点必须为叶结点
                flag = true;
            }
            if (node.right != null) {
                queue.addLast(node.right);
            } else {//记录标记，之后的结点必须为叶结点
                flag = true;
            }
        }
        return true;
    }
}
