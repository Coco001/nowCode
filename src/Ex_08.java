/**
 * 拓扑结构相同的子树
 */
public class Ex_08 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean chkIdentical(TreeNode A, TreeNode B) {
        String str1 = PreOrderTraverse(A);
        String str2 = PreOrderTraverse(B);
        return str1.contains(str2);
    }

    //前序遍历(根左右)
    private String PreOrderTraverse(TreeNode node) {
        if (node == null) {
            return "#!";
        }
        String res = node.val + "!";
        res += PreOrderTraverse(node.left);
        res += PreOrderTraverse(node.right);
        return res;
    }
    //后序遍历(左右根)
    private String PostOrderTraverse(TreeNode node) {
        if (node == null) {
            return "#!";
        }
        String res = PostOrderTraverse(node.left);
        res += PostOrderTraverse(node.right);
        res += node.val + "!";
        return res;
    }
    //中序遍历(左根右)不能达到目的
    private String InOrderTraverse(TreeNode node) {
        if (node == null) {
            return "#!";
        }
        String res = InOrderTraverse(node.left);
        res += node.val + "!";
        res += InOrderTraverse(node.right);
        return res;
    }
}
