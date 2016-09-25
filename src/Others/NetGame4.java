package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/18.
 */
public class NetGame4 {
    static int dx[] = {-1, -1, -1, 1, 1, 1, 0, 0};
    static int dy[] = {1, 0, -1, -1, 1, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            sc.nextLine();
            int[][] cheer = new int[8][8];
            for (int i = 0; i < 8; i++) {
                String line = sc.nextLine();
                char[] chars = line.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    cheer[i][j] = chars[j];
                }
            }
            int step = sc.nextInt();
            for (int i = 0; i < step; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int t = sc.nextInt();
                takeStep(cheer, x, y, t == 0 ? '*' : 'o');
            }
            int black = 0;
            int white = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (cheer[i][j] == '*')
                        black++;
                    else if (cheer[i][j] == 'o')
                        white++;
                }
            }
            System.out.println(black + " " + white);
        }
    }

    private static void takeStep(int[][] cheer, int x, int y, char c) {
        boolean valid = false;
        for (int i = 0; i < 8; i++) {
            int row = dx[i];
            int col = dy[i];
            int curRow = x + row;
            int curCol = y + col;
            boolean flag = false;
            boolean flagRow = false;
            while (curRow >= 0 && curRow < 8 && curCol >= 0 && curCol < 8) {
                if (cheer[curRow][curCol] == '.') {
                    flag = false;
                    break;
                } else if (cheer[curRow][curCol] != c) {
                    flag = true;
                } else {
                    if (flag) {
                        flagRow = true;
                        valid = true;
                        break;
                    }
                }
                curRow += row;
                curCol += col;
            }
            if (flagRow) {
                curRow = x + row;
                curCol = y + col;
                while (curRow >= 0 && curRow < 8 && curCol >= 0 && curCol < 8 && cheer[curRow][curCol] != c) {
                    cheer[curRow][curCol] = c;
                    curRow += row;
                    curCol += col;
                }
            }
        }
        if (valid)
            cheer[x][y] = c;
    }
}
