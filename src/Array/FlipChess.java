package Array;

import Utils.MyUtils;

/**
 * Created by lwy on 2016/9/2.
 */
public class FlipChess {
    private static int[][] flipChess(int[][] A,int[][] f){
        for(int[] a:f){
            int x = a[0] - 1;
            int y = a[1] - 1;
            if(x > 0)
                A[x - 1][y] = A[x-1][y] ^ 1;
            if(y >= 1)
                A[x][y - 1] = A[x][y - 1] ^ 1;
            if(x < 3)
                A[x + 1][y] = A[x + 1][y] ^ 1;
            if(y < 3)
                A[x][y + 1] = A[x][y + 1] ^ 1;
            MyUtils.print2DVector(A);
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = {{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}};
        int[][] f = {{2,2},{3,3},{4,4}};
        MyUtils.print2DVector(flipChess(A,f));
    }
}
