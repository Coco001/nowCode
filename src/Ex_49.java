/**
 * 找出现奇数次的数字
 */
public class Ex_49 {
    /**
     * 有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，
     * 请打印这个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
     * 给定整形数组A及它的大小n，请返回题目所求数字。
     * 测试样例：
     * [1,2,3,2,1],5
     * 返回：3
     */
    public int findOdd(int[] A, int n) {
        // write code here
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= A[i];
        }
        return res;
    }
    /**
     * 给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，
     * 找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
     * 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
     * 测试样例：
     * [1,2,4,4,2,1,3,5],8
     * 返回：[3,5]
     */
    public int[] findOdds(int[] arr, int n) {
        // write code here
        int res1 = 0;
        int[] res;
        for (int i = 0; i < n; i++) {
            res1 ^= arr[i];
        }
        //至此，res1为数组arr中两个出现了奇数次的数的异或结果
        int rightOne = res1 & (~res1 + 1);//一个数取反加一只保留该数最低位的1
        int res2 = 0;
        for (int i : arr) {
            if ((i & rightOne) != 0) {
                res2 ^= i;
            }
        }
        int s = Math.min(res2, res1 ^ res2);
        int m = Math.max(res2, res1 ^ res2);
        res = new int[]{s, m};
        return res;
    }
}
