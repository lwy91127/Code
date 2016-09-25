package Array;

/**
 * Created by lwy on 2016/9/14.
 * 对于一个矩阵，请设计一个算法，将元素按“之”字形打印。具体见样例。
 * 给定一个整数矩阵mat，以及他的维数nxm，请返回一个数组，其中元素依次为打印的数字。
 * 测试样例：
 * [[1,2,3],[4,5,6],[7,8,9],[10,11,12]],4,3
 * 返回：[1,2,3,6,5,4,7,8,9,12,11,10]
 */
public class PrintMatrix {
    public int[] printMatrix(int[][] mat, int n, int m) {
        int[] res = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[index++] = mat[i][Math.abs((1 & i) * (m - 1) - j)];
            }
        }
        return res;
    }
}
