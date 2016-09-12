package Others;

import org.junit.Test;

/**
 * Created by lwy on 2016/3/13.
 */
public class Transform {
    public int[][] transformFromImage(int[][] mat,int n){
        for(int layer = 0;layer < n/2;layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first;i < last;i++){
                int offset = i - first;
                int top = mat[first][i];
                mat[first][i] = mat[last-offset][first];
                mat[last-offset][first] = mat[last][last-offset];
                mat[last][last-offset] = mat[i][last];
                mat[i][last] = top;
            }
        }
        return mat;
    }

    @Test
    public void test(){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        mat = transformFromImage(mat,3);
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
