/**
 * 三色排序问题
 * 有一个只由 0 1 2三种元素组成的数组，使用交换、原地排序进行排序。
 */
public class Ex_04 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 1, 2, 2, 1, 1, 0, 0, 1, 0, 2, 0};
        sortThreeColor(test, 12);
    }
    private static int[] sortThreeColor(int[] A, int n) {
        int left = -1;//记录0元素个数索引
        int index = 0;//
        int right = n;//记录2元素位置索引
        while (index < right) {
            if (A[index] == 0) {
                int t = A[++left];
                A[left] = A[index];
                A[index++] = t;
            } else if (A[index] == 2) {
                int t = A[--right];
                A[right] = A[index];
                A[index] = t;
            } else {
                index++;
            }
        }
        return A;
    }
}
