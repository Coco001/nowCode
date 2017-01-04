
/**
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，
 * 定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
 * 保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 */
public class Ex_55 {
    private int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        // write code here
        //c0插入，c1删除，c2修改
        int[][] dp = new int[n + 1][m + 1];
        char[] chars1 = A.toCharArray();
        char[] chars2 = B.toCharArray();
        dp[0][0] = 0;//由A得空串变为B的空串代价为0
        //初始化第一列，由A中任意一个字符变为空字符只有一种方法，删除，删除的代价随着字符串长度的增加而增加
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i * c1;
        }
        //初始化第一行，由空串变为B中任意一个字符只有一种方法，插入，插入的代价随着字符串长度的增加而增加
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i * c0;
        }
        //整体计算
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int tmp1;//记录是否修改的价值
                if (chars1[i - 1] != chars2[j - 1]) {//对应位置不相等，代价为左上角的代价加上修改的代价
                    tmp1 = dp[i - 1][j - 1] + c2;
                } else {//对应位置相等，不需要进行任何操作，代价为左上角的代价
                    tmp1 = dp[i - 1][j - 1];
                }
                //dp[i - 1][j] + c1：表示A串插入一个字符的价值
                //dp[i][j - 1] + c0：表示A串删除一个字符的价值
                int tmp3 = Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c0);//取两者的最小值
                dp[i][j] = Math.min(tmp3, tmp1);//取三者的最小值
            }
        }
        return dp[n][m];
    }
}
