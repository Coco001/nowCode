/**
 * 对于一个给定的字符串数组，请找到一种拼接顺序，
 * 使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 * 测试样例：
 * ["abc","de"],2
 * "abcde"
 */
public class Ex_12 {
    //思路：对字符串数组进行排序：
    //如果 str1 + str2 <　str2 + str1，则str1放在前面，否则，str2放在前面
    
    public static void main(String[] args) {
        String[] test = new String[]{"abc","de"};
        System.out.println(findSmallest(test, 2));
    }

    private static String findSmallest(String[] strs, int n) {
        // write code here
        sortArrs(strs, n);
        return toString(strs, n);
    }

    private static String toString(String[] arrs, int n) {
        String res ="";
        for (int i = 0; i < n; i++) {
            res += arrs[i];
        }
        return res;
    }
    
    private static void sortArrs(String[] arrs, int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((arrs[j] + arrs[j + 1]).compareTo(arrs[j + 1] + arrs[j]) > 0) {
                    String temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }
}
