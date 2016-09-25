package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/3/14.
 */
public class ClearZero {
    public int[][] clear(int[][] mat, int n) {
        boolean[] row = new boolean[mat.length];
        boolean[] column = new boolean[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (row[i] || column[j]) {
                    mat[i][j] = 0;
                }
            }
        }
        String a = "";
        a.contains(a);
        return mat;
    }

    @Test
    public void test() {
        int[][] mat = {{1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
        mat = clear(mat, 3);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
