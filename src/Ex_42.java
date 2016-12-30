/**
 * 有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 */
public class Ex_42 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean check(TreeNode root) {
        // write code here
//        return chk(root) >= 0;
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];

    }

    private int getHeight(TreeNode node, int level, boolean[] res) {
        if (node == null) {
            return level;
        }
        int leftHeight = getHeight(node.left, level + 1, res);
        if (!res[0]) {//左子树是否为平衡二叉树
            return leftHeight;//左子树的深度
        }
        int rightHeight = getHeight(node.right, level + 1, res);
        if (!res[0]) {//右子树是否为平衡二叉树
            return rightHeight;//右子树的深度
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {//左右子树深度差超过1，不是平衡二叉树
            res[0] = false;
        }
        return Math.max(leftHeight, rightHeight);
    }

    private int chk(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = chk(node.left);//左边深度
        int r = chk(node.right);//右边深度
        if (l < 0 || r < 0) {
            return -1;
        }
        if ((Math.abs(r - l) > 1)) {//当左右两边深度差超过1时，返回-1
            return -1;
        }
        return r > l ? r + 1 : l + 1;
    }

}
