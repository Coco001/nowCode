/**
 * 对于一个有序循环数组arr，返回arr中的最小值。
 * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 * 测试样例：
 * [4,1,2,3,3],5
 * 返回：1
 */
public class Ex_35 {
    public int getMin(int[] arr, int n) {
        // write code here
        if (n < 0 || arr == null) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;
        if (n == 1 || arr[left] < arr[right]) {
            return arr[left];
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < arr[left]) {//最小值应该出现在左侧
                right = mid;
            } else if (arr[mid] > arr[left]) {//最小值应该出现在右侧
                left = mid;
            } else {//出现相等的情况
                mid++;
                break;
            }
        }
        return arr[mid];
    }
}
