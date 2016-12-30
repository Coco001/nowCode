import java.util.ArrayList;

/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展开。
 * 此时有1条折痕，突起的⽅向指向纸条的背面，这条折痕叫做“下”折痕 ；
 * 突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 * 测试样例：
 * 1
 * 返回：["down"]
 */
public class Ex_44 {
    public static void main(String[] args) {
        foldPaper(2);
    }

    private static ArrayList<String> list;
    private static String[] foldPaper(int n) {
        // write code here
        String[] res = new String[(1 << n) - 1];
        list = new ArrayList<>();
        PreOrderTraverse(1, n, true, res);
        int index = 0;
        for (String s : list) {
            res[index++] = s;
        }
        return res;
    }

    private static void PreOrderTraverse(int i, int n, boolean isDown, String[] res) {
        if (i > n) {
            return;
        }
        PreOrderTraverse(i + 1, n, true, res);
        list.add(isDown ? "down" : "up");
        PreOrderTraverse(i + 1, n, false, res);
    }
}
