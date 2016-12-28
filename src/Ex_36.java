/**
 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
 * 如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 * 测试样例：
 * [-1,0,2,3],4
 * 返回：2
 */
public class Ex_36 {
    public int findPos(int[] arr, int n) {
        // write code here
        int res = -1;
        if (arr == null || n < 1) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int mid;
        while (left <= right) {
            if (arr[left] > left || arr[right] < right) {
                break;
            }
            mid = left + (right - left) / 2;
            if (arr[mid] == mid) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
