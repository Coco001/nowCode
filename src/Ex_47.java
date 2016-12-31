/**
 * 有一棵二叉树，其中所有节点的值都不一样,找到含有节点最多 的搜索二叉子树,并返回这棵子树的头节点.
 * 给定二叉树的头结点root，请返回所求的头结点,若出现多个节点最多的子树，返回头结点权值最大的。
 */
public class Ex_47 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    //1、整体过程是二叉树的后序遍历
    //2、遍历到当前结点记为cur，先遍历cur的左子树并收集4个信息，
    // 分别是左子树上最大搜索二叉子树的头节点、结点数、树上的最小值和树上的最大值。
    // 再遍历cur的右子树收集4个信息，分别是右子树上最大搜索二叉子树的头节点、结点数、最小值、最大值。
    //3、根据步骤二收集的信息，判断是否满足以cur为头的结点整体是二叉搜索树。
    // 如果满足，就返回cur结点；如果不满足，就返回左子树和右子树各自的最大搜索二叉树中节点数较多的那个树的头节点。
    // 4、对于整个遍历过程，可以使用全局变量更新的方式实现返回节点cur的四个信息

    private TreeNode getMax(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        int[] res = new int[3];
        return PostOrderTraverse(root, res);
    }

    private TreeNode PostOrderTraverse(TreeNode node, int[] res) {
        if (node == null) {
            res[0] = 0;
            res[1] = Integer.MIN_VALUE;
            res[2] = Integer.MAX_VALUE;
            return null;
        }

        TreeNode nodeL = PostOrderTraverse(node.left, res);
        int lNum = res[0];//总结点数
        int lMax = res[1];//最大值
        int lMin = res[2];//最小值
        TreeNode nodeR = PostOrderTraverse(node.right, res);
        int rNum = res[0];
        int rMax = res[1];
        int rMin = res[2];
        res[1] = Math.max(node.val, rMax);
        res[2] = Math.min(lMin, node.val);
        if (nodeL == node.left && nodeR == node.right && lMax < node.val && rMin > node.val) {//要么返回当前结点
            res[0] = lNum + 1 + rNum;
            return node;
        }
        res[0] = Math.max(rNum, lNum);//要么返回当前结点左右子树上结点数较多的结点
        return rNum >= lNum ? nodeR : nodeL;
    }
}
