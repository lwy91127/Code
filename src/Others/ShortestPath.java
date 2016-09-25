package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/17.
 */
public class ShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String[] lineSp = sc.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.valueOf(lineSp[i]);
                }
            }
            System.out.println(prim(1, n, mat));
        }
    }

    private static int prim(int i, int n, int[][] mat) {
        int min;
        int cur = 0;
        int res = -1;
        boolean[] visit = new boolean[n];
        int[] w = new int[n];
        for (int j = 0; j < n; j++) {
            w[j] = mat[i][j];
        }
        w[i] = 0;
        visit[i] = true;
        for (int j = 0; j < n; j++) {
            min = Integer.MIN_VALUE;
            for (int k = 0; k < n; k++) {
                if (!visit[k] && w[k] < min) {
                    min = w[k];
                    cur = j;
                }
            }
            visit[cur] = true;
            if (res < min)
                res = min;
            for (int x = 0; x < n; x++) {
                if (!visit[x] && w[x] > mat[cur][x])
                    w[x] = mat[cur][x];
            }
        }

        return res;
    }
}
