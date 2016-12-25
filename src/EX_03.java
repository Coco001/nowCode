/**
 * 对于一个int数组，请编写一个冒泡排序算法，对数组元素排序。
 * 给定一个int数组A及数组的大小n，请返回排序后的数组。
 * 测试样例：
 * [1,2,3,5,2,3],6
 * [1,2,2,3,3,5]
 */
public class EX_03 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 2, 3, 3, 5};
        int[] res = radixSort(test, 6);
    }

    /**
     * 冒泡
     * @param A
     * @param n
     * @return
     */
    public static int[] bubbleSort(int[] A, int n) {
        // write code here
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int t = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = t;
                }
            }
        }
        return A;
    }

    /**
     * 选择
     * @param A
     * @param n
     * @return
     */
    public static int[] selectionSort(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            int min = A[i];
            for (int j = i; j < n; j++) {
                if (min > A[j]) {
                    int t = A[j];
                    A[j] = min;
                    min = t;
                }
            }
            A[i] = min;
        }
        return A;
    }

    /**
     * 插入
     * @param A
     * @param n
     * @return
     */
    public static int[] insertionSort(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && A[j] < A[j - 1]; j--) {
                A[j - 1] = A[j - 1] ^ A[j];
                A[j] = A[j - 1] ^ A[j];
                A[j - 1] = A[j - 1] ^ A[j];
            }
        }
        return A;
    }

    /**
     *
     * <1> 把长度为n的输入序列分成两个长度为n/2的子序列；
     * <2> 对这两个子序列分别采用归并排序；
     * <3> 将两个排序好的子序列合并成一个最终的排序序列。*/

    private static int[] aux;

    /**
     * 归并排序
     *
     * @param A
     * @param n
     * @return
     */
    public static int[] mergeSort(int[] A, int n) {
        aux = new int[n];
        sort(A, 0, n - 1);
        return A;
    }

    private static void sort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + ((right - left) >> 1);
        sort(arr, left, middle);//左侧排序
        sort(arr, middle + 1, right);//右侧排序
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int lo = left;
        int mid = middle + 1;

        for (int k = lo; k <= right; k++) {//将数组arr的lo到right位复制到数组aux中
            aux[k] = arr[k];
        }

        for (int k = lo; k <= right; k++) {//归并到数组arr中
            if (lo > middle) {             //左半边元素用尽，取右半边
                arr[k] = aux[mid++];
            } else if (mid > right) {   //右半边元素用尽，取左半边
                arr[k] = aux[lo++];
            } else if (aux[mid] < aux[lo]) {//右半边元素小于左半边元素，取右半边
                arr[k] = aux[mid++];
            } else {                      //右半边元素大于等于左半边元素，取左半边
                arr[k] = aux[lo++];
            }
        }
    }

    /**
     * 快速排序
     * @param A
     * @param n
     * @return
     */
    public static int[] quickSort(int[] A, int n) {
        // write code here
        qsort(A, 0, n - 1);
        return A;
    }

    private static void qsort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;         //存储小于切分元素的指针
        int i = lo + 1;      //存储等于切分元素的指针
        int gt = hi;         //存储大于切分元素的指针
        int split = arr[lo]; //切分元素
        while (i <= gt) {
            if (arr[i] < split) {
                int temp = arr[lt];
                arr[lt] = arr[i];
                arr[i] = temp;
                i++;
                lt++;
            } else if (arr[i] > split) {
                int temp = arr[gt];
                arr[gt] = arr[i];
                arr[i] = temp;
                gt--;
            } else {
                i++;
            }
        }//至此，a[lo...lt-1] < v=a[lt...gt] < a[gt+1...hi]
        qsort(arr, lo, lt - 1);
        qsort(arr, gt + 1, hi);
    }

    /**
     * 堆排序
     * @param A
     * @param n
     * @return
     */
    public static int[] heapSort(int[] A, int n) {
        // write code here
        for (int k = n/2; k >= 1; k--){
            sink(A, k, n);
        }
        while (n > 1) {
            exch(A, 1, n--);
            sink(A, 1, n);
        }
        return A;
    }
    private static void sink(int[] A, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && A[j-1] < A[j]) {
                j++;
            }

            if (A[k-1] >= A[j-1]) {
                break;
            }
            exch(A, k, j);
            k = j;
        }
    }

    private static void exch(int[] A, int i, int j) {
        int swap = A[i-1];
        A[i-1] = A[j-1];
        A[j-1] = swap;
    }

    /**
     * 希尔排序
     * @param A
     * @param n
     * @return
     */
    public static int[] shellSort(int[] A, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && A[j] < A[j - h]; j -= h) {
                    A[j] = A[j] ^ A[j - h];
                    A[j-h] = A[j] ^ A[j - h];
                    A[j] = A[j] ^ A[j - h];
                }
            }
            h /= 3;
        }
        return A;
    }

    /**
     * 计数排序
     * @param A
     * @param n
     * @return
     */
    public static int[] countingSort(int[] A, int n) {
        if (n < 2) {
            return A;
        }
        int min = A[0];
        int max = A[0];
        for (int i = 0; i < n; i++) {
            //找出待排序的数组中最大和最小的元素；
            min = min < A[i] ? min : A[i];
            max = max > A[i] ? max : A[i];
        }
        //统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
        int[] count = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            count[A[i] - min]++;
        }
        //
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                A[index++] = i + min;
            }
        }
        return A;
    }

    /**
     * 基数排序
     * @param A
     * @param n
     * @return
     */
    public static int[] radixSort(int[] A, int n) {
        if (n < 2) {
            return A;
        }
        int m = 1;
        int index = 1;
        int k = 0;
        int[][] help = new int[10][n];
        int[] count = new int[n];
        while (m++ <= 4) {
            for (int i = 0; i < n; i++) {
                int lsd = A[i] / index % 10;
                help[lsd][count[lsd]++] = A[i];
            }
            for (int i = 0; i < n; i++) {
                if (count[i] > 0) {
                    for (int j = 0; j < count[i]; j++) {
                        A[k++] = help[i][j];
                    }
                }
                count[i] = 0;
            }
            k = 0;
            index *= 10;
        }
        return A;
    }
}
