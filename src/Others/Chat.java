package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/5.
 */
public class Chat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int[][] pa = new int[p][2];
            for (int i = 0; i < p; i++) {
                pa[i][0] = sc.nextInt();
                pa[i][1] = sc.nextInt();
            }
            int[][] qa = new int[q][2];
            for (int j = 0; j < q; j++) {
                qa[j][0] = sc.nextInt();
                qa[j][1] = sc.nextInt();
            }
            int count = 0;
            for (int t = l; t <= r; t++) {
                if (canChat(pa, qa, t))
                    count++;
            }
            System.out.println(count);
        }
    }

    private static boolean canChat(int[][] pa, int[][] qa, int t) {
        for (int i = 0; i < pa.length; i++) {
            for (int j = 0; j < qa.length; j++) {
                if (pa[i][0] <= qa[j][1] + t && pa[i][1] >= qa[j][0] + t)
                    return true;
            }
        }
        return false;
    }
}
