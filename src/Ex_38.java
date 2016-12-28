import java.math.BigInteger;

/**
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，
 * 得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 * 测试样例：
 * 2,3
 * 返回：8
 */
public class Ex_38 {
    public static void main(String[] args) {
        System.out.println(BigInteger.valueOf(1));
    }
    public int getPower(int k, int N) {
        // write code here
        BigInteger res = BigInteger.valueOf(1);//保存结果
        BigInteger tmp = BigInteger.valueOf(k);
        for (; N != 0; N >>= 1) {
            if ((N & 1) != 0) {//判断最低位的值是否为0
                res = res.multiply(tmp);
            }
            tmp = tmp.multiply(tmp);
            res = res.mod(BigInteger.valueOf(1000000007));
            tmp = tmp.mod(BigInteger.valueOf(1000000007));
        }
        return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
