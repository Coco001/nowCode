
/**
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 */
public class Ex_53 {
    public static void main(String[] args) {
        String s1 = "zynnqufc";
        String s2 = "ddbauhkw";
        System.out.println(findLCS(s1, 8, s2, 8));
    }
    public static int findLCS(String A, int n, String B, int m) {
        // write code here
        int[][] res = new int[n + 1][m + 1];
        //第一行，第一列初始化为0（此处系统默认初始化）
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[n][m];
    }
}
