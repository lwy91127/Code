package Others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwy on 2016/3/31.
 */
public class PrintMatrix {
    public int[] Print(int[][] mat,int n ,int m){
        int starti = 0;
        int startj = 0;
        int endi = n;
        int endj = m;
        int[] res = new int[n*m];
        List<Integer> res1 = new ArrayList<>();
        int k = 0;
        while(starti < endi && startj < endj){

            if(starti == endi){
                for(int j = startj;j<endj;++j){
                    res[k++] = mat[starti][j];
                }
                return res;
            }
            if(startj == endj){
                for(int i = starti;i<endi;++i){
                    res[k++] = mat[i][startj];
                }
                return res;
            }
            int i = starti;
            int j = startj;
            for(j = startj;j<endj;j++){
                res[k++] = mat[i][j];
                System.out.print(i + " " + j + " ");
            }
            System.out.println();
            for(i = starti + 1,j--;i<endi;i++){
                res[k++] = mat[i][j];
                System.out.print(i + " " + j + " ");
            }
            System.out.println();
            for(j= j-1,i--;j>=startj;j--){
                res[k++] = mat[i][j];
                System.out.print(i + " " + j + " ");
            }
            System.out.println();
            for(i = i-1,j++;i>starti;i--){
                res[k++] = mat[i][j];
                System.out.print(i + " " + j + " ");
            }
            System.out.println();
            starti++;
            startj++;
            endi--;
            endj--;
        }
        return res;
    }

    @Test
    public void test(){
        int[][] mat = {{90,30,17},{28,96,90},{17,0,50},{44,12,67},{12,79,63},{43,63,40},{19,93,48}};
        int[][] mat1 = {{1,2,3,4},{5,6,7,8}};
        int [] res = Print(mat,7,3);
        for(int i = 0;i<res.length;i++ ){
            System.out.print(res[i] +" ");
        }
    }
}
