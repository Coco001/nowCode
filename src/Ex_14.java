/**
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class Ex_14 {
    //思路：
    //1、整形变量num，代表‘（’出现次数与‘）’出现次数的差值
    //2、遍历过程中如果遇到‘（’则num++
    //3、遍历过程中如果遇到‘）’则num--
    //4、遍历过程中如果num<0，则直接返回false
    //5、如果一直没有出现情况4，则一直遍历下去
    //6、遍历完成之后，如果出现num==0,则返回true，否则返回false。
    public boolean chkParenthesis(String A, int n) {
        // write code here
        int num = 0;
        char c;
        for (int i = 0; i < n; i++) {
            c = A.charAt(i);
            if (c == '(') {
                num++;
            } else if (c == ')') {
                num--;
            } else {
                return false;
            }
            if (num < 0) {
                return false;
            }
        }
        
        return num == 0;
    }
}
