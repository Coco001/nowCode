import java.util.*;

/**
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，
 * 所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。
 * 保证结点数小于等于500。
 */
public class EX_01 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int[][] printTree(TreeNode root) {
        // write code here
//        int[][] res = new int[500][500];
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
//        int row = 0;//记录数组的行
//        int line = 0;//记录数组的列
        TreeNode last = root;//记录正在打印行的最后一个节点
        TreeNode nlast = null;//记录下一行的最后一个节点
        TreeNode temp = null;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);//将根节点添加至队列
        while (!queue.isEmpty()) {
            temp = queue.poll();//获取队头元素
            row.add(temp.val);
//            res[row][line++] = temp.val;
            if (temp.left != null) {//添加左孩子并使nlast指向此处
                queue.add(temp.left);
                nlast = temp.left;
            }
            if (temp.right != null) {//添加右孩子并使nlast指向此处
                queue.add(temp.right);
                nlast = temp.right;
            }
            if (temp == last) {//判断当前行是否打印完毕
                last = nlast;
                rows.add(row);//将一行数据添加到结果中
                row = new ArrayList<>();//新建一行
//                row++;//行号+1
            }
        }
        int[][] res = new int[rows.size()][];//结果转化成数组形式
        for (int i = 0; i < rows.size(); i++) {
            res[i] = new int[rows.get(i).size()];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = rows.get(i).get(j);
            }
        }
        return res;
    }
}
