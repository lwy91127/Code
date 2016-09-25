package Array;

import java.util.ArrayList;

/**
 * Created by lwy on 2016/9/24.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * \则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix2 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int startLayer = 0;
        while (row > startLayer * 2 && col > startLayer * 2) {
            //左到右
            for (int i = startLayer; i < col - startLayer; i++) {
                res.add(matrix[startLayer][i]);
            }
            //上到下
            for (int j = startLayer + 1; j < row - startLayer; j++) {
                res.add(matrix[j][col - startLayer - 1]);
            }
            //右到左
            for (int m = col - startLayer - 2; m >= startLayer && (row - startLayer - 1) > startLayer; m--) {
                res.add(matrix[row - startLayer - 1][m]);
            }
            //从下到上
            for (int n = row - startLayer - 2; n >= startLayer + 1 && (col - startLayer - 1) > startLayer; n--) {
                res.add(matrix[n][startLayer]);
            }
            startLayer++;
        }
        return res;
    }
}
