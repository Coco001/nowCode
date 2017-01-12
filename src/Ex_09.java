
/**
 * 字符串变形检验
 */
public class Ex_09 {
    
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        if (A == null || B == null || lena != lenb) {
            return false;
        }
        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < lena; i++) {
            map[c1[i]]++;
        }
        for (int i = 0; i < lenb; i++) {
            if (map[c2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
