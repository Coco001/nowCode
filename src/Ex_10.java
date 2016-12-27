/**
 * 句子逆序输出
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，
 * 也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 * 测试样例：
 * "dog loves pig",13
 * 返回："pig loves dog"
 */
public class Ex_10 {
    public static void main(String[] args) {
        String test = "dog loves pig";
        System.out.println(reverseSentence(test, 13));
    }
    public static String reverseSentence(String A, int n) {
        if (A == null || n == 0) {
            return A;
        }
        char[] s = A.toCharArray();
        rotateWord(s);
        return String.valueOf(s);
    }

    private static void rotateWord(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        reverse(chars, 0, chars.length-1);//字符串整体逆序
        //至此字符串变为：gip sevol god
        int left = -1;
        int right = -1;
        for (int i = 0; i < chars.length; i++) {//逐个单词再逆序
            if (chars[i] != ' ') {//找出单词的左右索引
                left = i == 0 || chars[i - 1] == ' ' ? i : left;
                right = i == chars.length - 1 || chars[i + 1] == ' ' ? i : right;
            }
            if (left != -1 && right != -1) {//对单词进行逆序
                reverse(chars, left, right);
                left = -1;
                right = -1;
            }
        }
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
