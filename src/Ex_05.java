/**
 * 查找矩阵中是否包含某一个元素
 */
public class Ex_05 {
    
    public static boolean findX(int[][] A, int n, int m, int x) {
        int r = 0, c = m - 1;
        while (r < n && c >= 0) {
            if (A[r][c] == x) {
                return true;
            } else if (A[r][c] > x) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
