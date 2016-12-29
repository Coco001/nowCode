import java.util.LinkedList;
import java.util.Stack;

/**
 * 请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 */
public class Ex_40 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        /*tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);
        tree.right.left.left = new TreeNode(12);
        tree.right.left.right = new TreeNode(12);*/
        int[][] res = convert(tree);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        private TreeNode(int val) {
            this.val = val;
        }
    }

    private static int[][] convert(TreeNode root) {
        // write code here
        int[][] res = new int[3][];
        res[0] = PreOrderTraverse(root);
        res[1] = InOrderTraverse(root);
        res[2] = PostOrderTraverse(root);
        return res;
    }
    //前序遍历
    //1、申请一个栈，记为stack
    //2、将头节点head压入stack中
    //3、每次从stack中弹出栈顶结点，记为cur，然后打印cur结点的值。
    //如果cur右孩子不为空的话，将cur右孩子先压入stack中。
    //最后如果cur的左孩子不为空的话，将cur的左孩子压入stack中。
    //4、不断重复步骤3，直到stack为空，全部过程结束
    private static int[] PreOrderTraverse(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return listToArray(list);
    }
    //中序遍历
    //1、申请一个栈，记为stack，申请一个变量cur，初始时令cur=head
    //2、先把cur结点压入栈中，对以cur结点为头的整颗子树来说，一次把整颗树的左边界压入栈中，即不断令cur=cur.left，然后重复步骤2
    //3、不断重复步骤2，直到发现cur为空，此时从stack中弹出一个节点，记为node。打印node的值，并让cur=node.right，然后继续重复步骤2.
    //4、当stack为空，并且cur为空 全部过程结束
    private static int[] InOrderTraverse(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode temp;
        stack.push(cur);
        while (!stack.isEmpty()) {
            while (cur != null) {//一直将左子树压栈
                cur = cur.left;
                if (cur != null) {
                    stack.push(cur);
                }
            }
            temp = stack.pop();
            list.add(temp.val);
            cur = temp.right;
            if (cur != null) {
                stack.push(cur);
            }
        }
        return listToArray(list);
    }
    //后续遍历一
    //1、申请一个栈stack1，然后将头节点压入stack1
    //2、从stac1中弹出的结点记为cur，然后先把cur的左孩子压入stac1中，然后把cur的右孩子压入stack1
    //3、在整个过程中，每一个从stack1中弹出的结点都放入第二个栈stack2中
    //4、不断重复步骤2和步骤3，直到stack1为空，过程停止
    //5、从stack2中依次弹出结点并打印，打印的顺序就是后序遍历的顺序
    private static int[] PostOrderTraverse(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        TreeNode cur;
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
            stack2.push(cur);
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return listToArray(list);
    }
    //后续遍历二
    // 1、申请一个栈stack，将头节点压入栈stack。同时设置两个变量h和c，
    // 在整个流程中，h代表最近一次弹出并打印的节点，c代表当前stack的栈顶结点，初始时令h为头节点，c为null
    // 2、每次令c等于当前stack的栈顶结点，但是不从stack中弹出结点，此时分为以下三种情况：
          //（1）如果c的左孩子不为空，并且h不等于c的左孩子，也不等于c的有孩子，则把c的左孩子压入stack中
          //（2）如果情况1不成立，并且c的右孩子不为空，并且h不等于c的右孩子，则把c的右孩子压入stack中
          //（3）如果情况1和情况2都不成立，那么从stack中弹出c并打印，然后令h等于c
    // 3、一直重复步骤2，直到stack为空，过程停止

    private static int[] PostOrderTraverse2(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode h = node;
        TreeNode c;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                stack.push(c.left);
            } else if (c.right != null && h != c.right) {
                stack.push(c.right);
            } else {
                h = stack.pop();
                list.add(h.val);
            }
        }
        return listToArray(list);
    }
    private static int[] listToArray(LinkedList<Integer> list) {
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            res[index++] = i;
        }
        return res;
    }
}
