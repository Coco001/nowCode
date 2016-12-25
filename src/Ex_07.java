/**
 * 排序之后相邻两数只差最大
 */
public class Ex_07 {
    private static int maxGap(int[] A, int n) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {//获取数组中的最大值和最小值
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[n + 1];
        int[] maxs = new int[n + 1];
        int[] mins = new int[n + 1];
        int bid = 0;
        for (int i = 0; i < n; i++) {
            bid = bucket(A[i], n, min, max); // 算出A[i]的桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], A[i]) : A[i];//记录桶中最小值
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], A[i]) : A[i];//记录桶中最大值
            hasNum[bid] = true;
        }//至此，所有元素都装入了桶中，并且可以通过mins数组和maxs数组知道任一桶中的最大值与最小值
        int res = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= n) {
            if (hasNum[i++]) { // 找到第一个不空的桶
                lastMax = maxs[i - 1];//记录第一个不为空的桶中的最大值
                break;
            }
        }
        for (; i <= n; i++) {
            if (hasNum[i]) {// 桶非空
                res = Math.max(res, mins[i] - lastMax);//求取当前桶中的最小值与上一个桶中的最大值的差，对比求取差值最大的
                lastMax = maxs[i];//更新上一个桶中的最大值
            }
        }
        return res;
    }

    // 使用long类型是为了防止相乘时溢出
    private static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
