/**
 * 最短需要排序的子数组长度
 */
public class Ex_06 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 4, 6, 5, 9, 10};
        shortestSubsequence(test, 6);
    }
    private static int shortestSubsequence(int[] A, int n) {
        int left = 0;//最大值比当前元素大情况发生出现在最右侧的位置
        int right = 0;//最小值比当前元素小情况发生出现在最左侧的位置
        int max = A[0];
        int min = A[n - 1];
        for (int i = 1; i < n; i++) {
            if (max <= A[i]) {
                max = A[i];
            } else {
                left = i;
            }
        }
        for (int i = n-1; i >= 0; i++) {
            if (min >= A[i]) {
                min = A[i];
            } else {
                right = i;
            }
        }
        return left - right == 0 ? 0 : left - right + 1;
    }
}
