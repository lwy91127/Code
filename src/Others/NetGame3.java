package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/18.
 */
public class NetGame3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int N = sc.nextInt();
            while (N-- > 0) {
                int t = sc.nextInt();
                int s = sc.nextInt();
                int e = sc.nextInt();
                int curPos = 1;
                int curTime = 1;
                if (curTime < s) {
                    System.out.println(s - t);
                }
            }
            System.out.println();
        }
    }
}
