
/**
 * 有数组penny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 */
public class Ex_50 {
    private static int countWays(int[] penny, int n, int aim) {
        // write code here
        int[][] map = new int[n][aim + 1];
        //初始化第一列。组成面值为0的情况，无论使用任何种货币，只能有一种组合方式，那就是不使用任何面值的货币
        for (int i = 0; i < n; i++) {
            map[i][0] = 1;
        }
        //初始化第一行。当前面值可以整除第一个货币的面值，则有一种一种组合方式
        for (int i = 1; i < aim + 1; i++) {
            if (i % penny[0] == 0) {
                map[0][i] = 1;
            }
        }
        //填充map数组
        for (int i = 1; i < n; i++) {//遍历所有行
            for (int j = 1; j < aim + 1; j++) {//遍历所有列
                if (j >= penny[i]) {//当前面值不小于当前使用的货币
                    //当前面值=不使用当前面值的情况+使用当前面值的情况
                    map[i][j] = map[i - 1][j] + map[i][j - penny[i]];
                } else {//当前面值小于当前使用的货币
                    //当前面值=不使用当前面值的情况
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        return map[n-1][aim];
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,3,6};
        System.out.println(countWays(test, 3, 13));
    }
}
