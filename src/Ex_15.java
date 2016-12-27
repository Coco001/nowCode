/**
 * 对于一个字符串，请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串以及字符串的长度，返回最长无重复子串的长度。
 * 测试样例：
 * "aabcd",5
 * 返回：3
 */
public class Ex_15 {
    public static void main(String[] args) {
        String test = "aabcd";
        System.out.println(longestSubstring(test, 5));
    }
    private static int longestSubstring(String A, int n) {
        if (A == null || n == 0) {
            return 0;
        }
        char[] chars = A.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {//初始化每个字符首次出现的位置为-1
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur;
        //map:保存了每种字符之前出现的位置
        //pre:代表以当前字符前一个字符结尾的情况下，最长无重复子串的长度
        //首先，取出当前字符上一次出现的位置（通过map）
        for (int i = 0; i < n; i++) {
            //根据当前最长无重复子串的长度，更新pre
            pre = Math.max(pre, map[chars[i]]);
            //当前字符出现的位置到以当前字符前一个字符结尾的最长子串之间的距离
            cur = i - pre;//当前字符结尾的最长无重复子串长度
            //以当前字符前一个字符结尾的最长无重复子串长度、当前字符结尾的最长无重复子串长度；二者的最大值
            len = Math.max(len, cur);
            map[chars[i]] = i;//更新当前字符出现的位置
        }
        /*for (int i = 0; i < n; i++) {
            pre = pre > map[chars[i]] ? pre : map[chars[i]];
            len = (i - pre) > len ? (i - pre) : len;
            map[chars[i]] = i;
        }*/
        return len;
    }
}
