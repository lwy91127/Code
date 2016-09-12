package Others;

import java.util.HashMap;

/**
 * Created by lwy on 2016/9/2.
 */
public class CaculateDis {
    private static int caculateDis(int A,int B,int C,int D){
        return getDistance(A) + getDistance(B) + getDistance(C) + getDistance(D);
    }

    private static int getDistance(int a) {
        int i,j,k=0;
        for(i=0,j=-1;j==0;i++,j++)
        {
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(getDistance(0));
    }
}
