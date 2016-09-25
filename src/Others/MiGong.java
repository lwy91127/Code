package Others;

import Utils.MyUtils;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/18.
 */
public class MiGong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int[][] mat = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            MyUtils.print2DVector(mat);
            int[][] dp = new int[n + 1][m + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (mat[i][j] == 1 && (mat[i][j - 1] == 1 || mat[i - 1][j] == 1)) {
                        dp[i][j] = Math.max(p--, dp[i - 1][j]);
                        int tempi = i;
                        while (mat[tempi - 1][j] == 1 && dp[tempi - 1][j] == 0) {
                            dp[tempi - 1][j] = Math.max(dp[tempi - 1][j], dp[tempi][j] - 3);
                            tempi--;
                            if (tempi < 0)
                                break;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            MyUtils.print2DVector(dp);
            System.out.println(dp[1][m]);
        }
    }
}
