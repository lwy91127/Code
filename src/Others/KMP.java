package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/5.
 */
public class KMP {
    public int indexOf(String A, int lena, String B, int lenb) {
        if (lenb > lena)
            return -1;
        int[] next = getNextArray(B);
        int i = 0;
        int j = 0;
        while (i < lena && j < lenb) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == lenb ? i - j : -1;
    }

    private int[] getNextArray(String b) {
        if (b.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[b.length()];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int last = 0;
        while (index < b.length()) {
            if (b.charAt(index - 1) == b.charAt(last)) {
                next[index++] = ++last;
            } else if (last > 0) {
                last = next[last];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    @Test
    public void test() {
        System.out.println(indexOf("jnduwslil", 9, "i", 1));
    }
}
