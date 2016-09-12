package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/4/6.
 */
public class Microsoft {
    public static int getFontSize(int N,int P,int W,int H,int[] lineNumber){
        int i = 1;
        int result = 0;
        while(i<=Math.min(W,H)){
            int n = W / i;
            int l = H / i;
            int sumline = 0;
            for(int j = 0;j<lineNumber.length;j++){
                int addition = (lineNumber[j] % n == 0)?0:1;
                sumline += lineNumber[j] / n + addition;
            }
            int page = (sumline/l) + (sumline % l==0?0:1);

            if(page <= P){
                result = i;
                i++;
            }else{
                break;
            }
        }
        return result;
    }

    public static int getMinGridChange(int n,int m,char[][] maze){
        int mostright = 0;
        int mostbottom = 0;
        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(j < mostright - 1){
                    dp[i][j] = Integer.MAX_VALUE;
                }else{
                    if (maze[i][j] == '.') {
                        if(j == mostright -1){
                            dp[i][j] = 0;
                        }else{
                            if(i==0) {
                                if(j==0){
                                    dp[i][j] = 0;
                                }else {
                                    dp[i][j] = dp[i][j - 1];
                                }
                            }else{
                                if(j+1 <m && maze[i-1][j+1] == 'b'){
                                    dp[i][j] = dp[i-1][j];
                                }else{
                                    dp[i][j] = dp[i][j-1];
                                }
                            }
                        }

                    } else if (maze[i][j] == 'b') {
                        if(mostright == 0)
                            mostright = j;
                        dp[i][j] += 1;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] arr = new char[n][m];
        for(int i =0;i<n;i++){
            String line = scanner.next();
            for(int j = 0;j<m;j++){
                arr[i][j] = line.charAt(j);
            }
        }

        System.out.println(getMinGridChange(n,m,arr));
    }
}
