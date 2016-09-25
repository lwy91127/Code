package Others;

import org.junit.Test;

import java.io.*;

/**
 * Created by lwy on 2016/4/21.
 */
public class LongestSameSubStr {
    int[][] dp;
    int[][] flag; //标记位，方便回溯找序列

    public void getDPMaxtri(String a, String b) {
        dp = new int[a.length() + 1][b.length() + 1];
        flag = new int[a.length() + 1][b.length() + 1];
        //初始化dp边界
        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    flag[i][j] = 0;
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    flag[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    flag[i][j] = -1;
                }
            }
        }
    }

    public void getLSC(String[] a, String[] b) {
        dp = new int[a.length + 1][b.length + 1];
        //初始化dp边界
        for (int i = 0; i <= a.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= b.length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1].equals(b[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
    }

    void printResult(String s, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (flag[i][j] == 0) {
            printResult(s, i - 1, j - 1);
            System.out.println(s.charAt(i - 1) + "i:" + (i - 1) + "j:" + (j - 1));
        } else if (flag[i][j] == 1) {
            printResult(s, i - 1, j);
        } else {
            printResult(s, i, j - 1);
        }
    }

    @Test
    public void test() {
//        String a = "ABCBDAB";
//        String b = "BDCABA";
//        getDPMaxtri(a,b);
//        System.out.println(dp[a.length()][b.length()]);
//        printResult(a,a.length(),b.length());
        String[] a = {"111", "123", "122", "145"};
        String[] b = {"111", "143", "122", "145"};
        File f = new File("traj");
        File f2 = new File("queryresult");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));
            String line = br.readLine();
            String line2 = br.readLine();
            a = line.split(", ");
            b = line.split(", ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getLSC(a, b);
        System.out.println(dp[a.length][b.length]);
    }
}