package HuaWei;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/6.
 * 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
 * <p>
 * 输入描述:
 * 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。'
 * <p>
 * 输出描述:
 * 输出九行，每行九个空格隔开的数字，为解出的答案。
 */
public class ShuDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] matrix = new int[9][9];
            boolean[][] rowValue = new boolean[9][9]; // 行中已填入的数字
            boolean[][] colValue = new boolean[9][9]; // 列中已填入的数字
            boolean[][] blockValue = new boolean[9][9]; // 3*3格子中填入的数字
            for (int i = 0; i < 9; i++) {
                String line = sc.nextLine();
                String[] lineSplit = line.split(" ");
                for (int j = 0; j < 9; j++) {
                    matrix[i][j] = Integer.valueOf(lineSplit[j]);
                    if (matrix[i][j] != 0) {
                        int k = i / 3 * 3 + j / 3; //第几个3*3格子
                        int value = matrix[i][j] - 1; //下标需要减一
                        rowValue[i][value] = true;
                        colValue[j][value] = true;
                        blockValue[k][value] = true;
                    }
                }
            }
            slove(matrix, rowValue, colValue, blockValue);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println(matrix[i][8]);
            }
        }
    }

    private static boolean slove(int[][] matrix, boolean[][] rowValue, boolean[][] colValue, boolean[][] blockValue) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    int k = i / 3 * 3 + j / 3;
                    for (int v = 0; v < 9; v++) {
                        if (!rowValue[i][v] && !colValue[j][v] && !blockValue[k][v]) {
                            rowValue[i][v] = colValue[j][v] = blockValue[k][v] = true;
                            matrix[i][j] = v + 1;
                            if (slove(matrix, rowValue, colValue, blockValue)) //递归搜索
                                return true;
                            rowValue[i][v] = colValue[j][v] = blockValue[k][v] = false;
                            matrix[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
