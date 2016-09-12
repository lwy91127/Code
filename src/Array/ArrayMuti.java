package Array;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/11.
 *
 * A[n,m]是一个n行m列的矩阵，a[i,j]表示A的第i行j列的元素，定义x[i,j]为A的第i行和第j列除了a[i,j]之外所有元素(共n+m-2个)的乘积，
 * 即x[i,j]=a[i,1]*a[i,2]*...*a[i,j-1]*...*a[i,m]*a[1,j]*a[2,j]...*a[i-1,j]*a[i+1,j]...*a[n,j],
 * 现输入非负整形的矩阵A[n,m]，求MAX(x[i,j])，即所有的x[i,j]中的最大值。
 输入例子:
 3 5
 5 1 8 5 2
 1 3 10 3 3
 7 8 5 5 16

 输出例子:
 358400
 */
public class ArrayMuti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for(int i = 0;i<n;i++){
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            long res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int rsum = 1;
                    for(int r = 0;r < m;r++){
                        if(r == j)
                            continue;
                        rsum *= matrix[i][r];
                    }
                    int csum = 1;
                    for(int c = 0;c < n;c++){
                        if(c == i)
                            continue;
                        csum *= matrix[c][j];
                    }
                    res = Math.max(res,rsum * csum);
                }
            }
            System.out.println(res);
        }
    }
}
