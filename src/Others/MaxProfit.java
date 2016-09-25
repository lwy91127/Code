package Others;

import java.util.Scanner;

/**
 * Created by lwy on 2016/9/1.
 */
public class MaxProfit {
    private static int getMaxProfit(int[] prices) {
        int l = prices.length;
        if (l < 2)
            return 0;
        int[] preProfit = new int[l];
        int[] postProfit = new int[l];

        int curMin = prices[0];
        for (int i = 1; i < l; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }

        int curMax = prices[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < l; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        return maxProfit;
    }

    public static int maxProfit(int[] a) {
        int curMin = a[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            curMin = Math.min(curMin, a[i]);
            max = Math.max(max, a[i] - curMin);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] lineSp = sc.nextLine().split(",");
            int[] a = new int[lineSp.length];
            for (int i = 0; i < lineSp.length; i++) {
                a[i] = Integer.valueOf(lineSp[i]);
            }
            int curMin = a[0];
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < a.length; i++) {
                curMin = Math.min(curMin, a[i]);
                max = Math.max(max, a[i] - curMin);
            }
            System.out.println(max);
        }
    }
}
