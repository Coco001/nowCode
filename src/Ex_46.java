/**
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当
 * 到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 */
public class Ex_46 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.right.right.right = new TreeNode(10);
/*        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);
        tree.right.left.left = new TreeNode(12);
        tree.right.left.right = new TreeNode(13);*/

        System.out.println(findLongest(tree));

    }
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    private static int findLongest(TreeNode root) {
        // write code here
        int[] res = new int[1];
        return findLongestCore(root, res);
    }

    private static int findLongestCore(TreeNode node, int[] res) {
        if (node == null) {
            res[0] = 0;
            return 0;
        }
        int LMax = findLongestCore(node.left, res);//当前节点左子树上距离当前结点左孩子的最远距离
        int maxLeftChild = res[0];//当前结点左子树上距离当前节点最远的距离（不包括当前节点自身）
        int RMax = findLongestCore(node.right, res);//当前节点右子树上距离当前结点右孩子的最远距离
        int maxRightChild = res[0];//当前结点左子树距离当前节点最远的距离（不包括当前节点自身）
        res[0] = Math.max(maxLeftChild + 1, maxRightChild + 1);//当前结点的子树距离当前结点的最远距离（包括当前结点）
        return Math.max(Math.max(LMax, RMax), maxLeftChild + maxRightChild + 1);
    }
}
