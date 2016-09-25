package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/4/28.
 */
public class MixtureStrs {
    public boolean mixtrue(String a, int n, String b, int m, String c, int l) {
        if (n + m != l)
            return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        char[] cchars = c.toCharArray();
        for (int j = 1; j < m + 1; j++) {
            if (dp[0][j - 1] && (bchars[j - 1] == cchars[j - 1])) {
                dp[0][j] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (dp[i - 1][0] && achars[i - 1] == cchars[i - 1]) {
                dp[i][0] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (dp[i - 1][j] && achars[i - 1] == cchars[i + j - 1]) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && bchars[j - 1] == cchars[i + j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][m];
    }

    @Test
    public void test() {
        System.out.println(mixtrue("ABC", 3, "12C", 3, "A12BCC", 6));
    }
}
