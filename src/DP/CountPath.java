package DP;

/**
 * Created by lwy on 2016/9/2.
 */
public class CountPath {
    private static int countPath(int[][] map,int n,int m){
        int px = -1;
        int py = -1;
        int sx = -1;
        int sy = -1;
        for(int i = 0;i<map.length;i++){
            for(int j = 0;j<map[0].length;j++){
                if(map[i][j] == 1){
                    px = i;
                    py = j;
                }else if(map[i][j] == 2){
                    sx = i;
                    sy = j;
                }
            }
        }
        int hd = py > sy?-1:1;
        int vd = px > sx?-1:1;

        int[][] dp = new int[n][m];
        for(int i = px;i!=sx + vd;i+=vd){
            for(int j = py;j!= sy + hd;j+=hd){
                if(i==px || j == sx){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j-hd] + dp[i-vd][j];
            }
        }
        return dp[sx][sy];
    }

    public static void main(String[] args) {
        int[][] a = {{0,1,0},{2,0,0}};
        System.out.println(countPath(a,2,3));
    }
}
