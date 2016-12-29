/**
 * 给定一棵完全二叉树的根节点root，返回这棵树的节点个数。
 * 如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 */
public class Ex_37 {
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
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);
        tree.right.left.left = new TreeNode(12);
        tree.right.left.right = new TreeNode(12);

        System.out.println(count(tree));

    }
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int count(TreeNode root) {
        // write code here
        int res = 0;
        int height = getHeight(root);//获取数的高度
        if (height == 1) {
            return 1;
        }
        while (height > 1) {//可以改为：while (root != null)
            if (height == getHeight(root.right) + 1) {//左侧为满树
                res += 1 << (height - 1);//把左侧的满树子结点个数加到结果中
                root = root.right;
            } else {//右侧为高度少一的满树
                res += 1 << (height - 2);
                root = root.left;
            }
            height--;
        }
        return res + 1;//对应于：while (root != null)可以改为 return res；
    }

    private static int getHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h += 1;
            node = node.left;
        }
        return h;
    }
}
