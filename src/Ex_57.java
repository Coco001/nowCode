/**
 * 有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
 * 给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。
 */
public class Ex_57 {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        while (m != 0) {
            if (n == 0) {
                A[m - 1] = B[m - 1];
                m--;
            } else {
                A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
            }
        }
        return A;
    }
}
