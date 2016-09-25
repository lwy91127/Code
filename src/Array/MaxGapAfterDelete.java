package Array;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/5.
 */
public class MaxGapAfterDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int res = 0;
            for (int i = 2; i < n - 1; i++) {
                res = Math.max(res, a[i] - a[i - 1]);
            }
            System.out.println(res);
        }
    }
}
