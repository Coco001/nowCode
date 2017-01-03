/**
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，
 * 每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 */
public class Ex_54 {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here
        int[][] res = new int[n][cap + 1];
        //初始化第一列
        for (int i = 0; i < n; i++) {
            res[i][0] = 0;
        }
        //初始化第一行
        for (int i = 1; i < cap + 1; i++) {
            if (i >= w[0]) {
                res[0][i] = v[0];
            }
        }
        int weight = 0;
        for (int i = 1; i < n; i++) {
            weight += w[i-1];//前i-1个物品的总重
            for (int j = 1; j < cap + 1; j++) {
                if (j - weight >= w[i]) {//当前背包的容量可以容纳当前遇到的物品
                    res[i][j] = res[i - 1][j] + v[i];
                } else {
                    if (j >= w[i]) {//当前背包容量是否能够容纳下当前遇到的物品
                        //取不包含当前遇到的物品、包含当前遇到的物品；两者价值的最大值
                        res[i][j] = Math.max(res[i - 1][j - w[i]] + v[i], res[i - 1][j]);
                    } else {//当前背包容量不足以能够容纳下当前遇到的物品
                        //价值只能是不包含当前物品
                        res[i][j] = res[i - 1][j];
                    }
                }
            }
        }
        return res[n - 1][cap];
    }

    public int maxValue01(int[] w, int[] v, int n, int cap) {
        // dp[x][y]表示物品数量为x,重量不超过y时背包中的总价值
        //两种情况：1.将x物品不加入到背包中，那么前x-1件物品的总重量不应该超过y。dp[x][y] = dp[x-1][y]
        //2.将x物品加入到背包中，那么前x-1前物品的总重量不应该超过y-w(x),因此dp[x][y] = dp[x-1][y-w(x)]+v(x);
        int[] dp = new int[cap+1];
        for(int i=0;i<n;i++){//控制物品的数量
            for(int j=cap;j>=w[i];j--){//空背包中不能超重
                dp[j] = dp[j]>=dp[j-w[i]]+v[i]?dp[j]:dp[j-w[i]]+v[i];//选取j加入书包与j不加入书包的较大值
            }
        }
        return dp[cap];//返回数组的最后一位即是最大总价值
    }
}
