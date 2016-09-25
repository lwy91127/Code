package DP;

import Utils.MyUtils;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/5.
 */
public class Moguzheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] matrix = new int[n + 1][m + 1];
            sc.nextLine();
            while (k > 0) {
                String[] linesp = sc.nextLine().split(" ");
                int x = Integer.valueOf(linesp[0]);
                int y = Integer.valueOf(linesp[1]);
                matrix[x][y] = -1;
                k--;
            }
            MyUtils.print2DVector(matrix);
            double[][] dp = new double[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (matrix[i][j] == -1)
                        dp[i][j] = 0;
                    else if (i == 1 && j == 1)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j] * ((j == m) ? 1 : 0.5) + dp[i][j - 1] * (i == n ? 1 : 0.5);
                }
            }
            MyUtils.print2DVector(dp);
            System.out.printf("%.2f", dp[n][m]);
        }
    }
}

