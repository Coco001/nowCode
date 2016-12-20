/**
 * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 */
public class EX_03 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 5, 2, 3};
        int[] res = bubbleSort(test, 6);
    }

    public static int[] bubbleSort(int[] A, int n) {
        // write code here
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int t = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = t;
                }
            }
        }
        return A;
    }
}
