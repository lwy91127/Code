package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/14.
 */
public class ClearMushroom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] matrix = new int[n + 1][m + 1];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                matrix[x][y] += 1;
            }
            int res = 0;
            for (int x = 0; x < 2; x++) {
                int max = 0;
                int maxi = 0;
                int maxj = 0;
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        int sum = getSum(matrix, i, j, n, m);
                        if (sum > max) {
                            max = sum;
                            maxi = i;
                            maxj = j;
                        }
                    }
                }
                deleteMatrix(matrix, maxi, maxj, n, m);
                res += max;
            }
            System.out.println(res);
        }
    }

    private static void deleteMatrix(int[][] mat, int i, int j, int n, int m) {
        if (mat[i][j] > 0)
            mat[i][j]--;
        if (i - 1 > 0 && mat[i - 1][j] > 0)
            mat[i - 1][j]--;
        if (j - 1 > 0 && mat[i][j - 1] > 0)
            mat[i][j - 1]--;
        if (i - 1 > 0 && j - 1 >= 0 && mat[i - 1][j - 1] > 0)
            mat[i - 1][j - 1]--;
        if (i + 1 <= n && mat[i + 1][j] > 0)
            mat[i + 1][j]--;
        if (j + 1 <= m && mat[i][j + 1] > 0)
            mat[i][j + 1]--;
        if (i + 1 <= n && j + 1 <= m && mat[i + 1][j + 1] > 0)
            mat[i + 1][j + 1]--;
        if (i - 1 > 0 && j + 1 <= m && mat[i - 1][j + 1] > 0)
            mat[i - 1][j + 1]--;
        if (i + 1 <= n && j - 1 > 0 && mat[i + 1][j - 1] > 0)
            mat[i + 1][j - 1]--;
    }

    private static int getSum(int[][] mat, int i, int j, int n, int m) {
        int res = 0;
        if (mat[i][j] > 0)
            res++;
        if (i - 1 > 0 && mat[i - 1][j] > 0)
            res++;
        if (j - 1 > 0 && mat[i][j - 1] > 0)
            res++;
        if (i - 1 > 0 && j - 1 >= 0 && mat[i - 1][j - 1] > 0)
            res++;
        if (i + 1 <= n && mat[i + 1][j] > 0)
            res++;
        if (j + 1 <= m && mat[i][j + 1] > 0)
            res++;
        if (i + 1 <= n && j + 1 <= m && mat[i + 1][j + 1] > 0)
            res++;
        if (i - 1 > 0 && j + 1 <= m && mat[i - 1][j + 1] > 0)
            res++;
        if (i + 1 <= n && j - 1 > 0 && mat[i + 1][j - 1] > 0)
            res++;
        return res;
    }
}
