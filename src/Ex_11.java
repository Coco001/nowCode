
/**
 * 字符串移位
 * 1、将ABCDE的[0 1 2]部分的字符串逆序：CBADE
 * 2、将ABCDE的[3 4]部分的字符串逆序：CBAED
 * 3、将整体逆序：DEABC
 */
public class Ex_11 {
    
    public static void main(String[] args) {
        String test = "ABCDE";
        System.out.println(stringTranslation(test, 5, 3));
    }
    
    public static String stringTranslation(String A, int n, int len) {
        // write code here
        if (A == null || n == 0) {
            return A;
        }
        char[] s = A.toCharArray();
        reverse(s, 0, len - 1);
        reverse(s, len, n - 1);
        reverse(s, 0, n - 1);
        return String.valueOf(s);
    }
    
    private static void reverse(char[] chas, int start, int end) {//逆序代码
        char temp;
        while (start < end) {
            temp = chas[start];
            chas[start] = chas[end];
            chas[end] = temp;
            start++;
            end--;
        }
    }
}
