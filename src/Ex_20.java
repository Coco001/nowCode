import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置，返回一个长度为n-w+1的数组res，res[ i ]表示每一种窗口状态下的最大值。
 * 以数组为[4,3,5,4,3,3,6,7]，w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。
 * 第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 * 给定整形数组arr及它的大小 n，同时给定 w，请返回res数组。保 w 小于等于n，同时保证数组大小小于等于500
 * 测试样例：
 * [4,3,5,4,3,3,6,7],8,3
 * <p>
 * 返回：[5,5,5,4,6,7]
 */
public class Ex_20 {

    public static void main(String[] args) {
        int[] test = new int[]{4,3,5,4,3,3,6,7};
        slide(test, 8, 3);
    }

    /*思路：
    创建双端队列qmax={}，双端队列存放着数组中的下标值，假设当前数为arr[ i ]
    放入规则为：
    如果qmax为空，直接把下标 i 放入qmax中
    如果qmax不为空，取出当前qmax队尾存放的下标 j 。如果arr[ j ] > arr[ i ]，直接把下标 i 放进qmax的队尾
    如果arr[ j ] <= arr[ i ]，则一直从qmax的队尾弹出下标，直到某个下标在qmax中对应的值大于arr[ i ]，把 i 放入qmax的队尾
    弹出规则为：
    如果qmax队头的下标等于 i - w ，弹出qmax当前队头的下标*/

    public static int[] slide(int[] arr, int n, int w) {
        // write code here
        int[] res = new int[n - w + 1];
        int index = 0;
        ArrayDeque<Integer> qMax = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            //放入
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            //弹出
            if ((i - w) == qMax.peekFirst()) {
                qMax.pollFirst();
            }
            //取出符合条件的结果集
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }
}
