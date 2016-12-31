/**
 * 寻找两个数中较大的一个
 */
public class Ex_48 {
    private static int getMax3(int a, int b) {
        int c = (a - b) >> 31;
        return a + c * (a - b);
    }
    private static int getMax2(int a, int b) {
        int c = a - b;
        int as = sign(a);//a的符号，结果为1表示a非负
        int bs = sign(b);//b的符号，结果为1表示b非负
        int cs = sign(c);//c的符号，结果为1表示c非负
        int difab = as ^ bs;//1表示a与b的符号不相同，0表示a与b的符号位相同
        int sameab = flip(difab);//1表示a与b的符号相同，0表示a与b的符号位不相同
        int returnA = difab * as + sameab * cs;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    private static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    private static int sign(int n) {//获取n的符号位，一个数右移31位后&1表示获取该数的符号位
        return flip((n >> 31) & 1);
    }

    private static int flip(int n) {
        return n ^ 1;
    }

    public static void main(String[] args) {
        System.out.println(getMax1(3, 5));
    }
}
