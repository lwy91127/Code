package Others;

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
            curMax = Math.max(curMax,prices[i]);
            postProfit[i] = Math.max(postProfit[i+1],curMax - prices[i]);
        }

        int maxProfit = 0;
        for(int i = 0;i < l;i++){
            maxProfit = Math.max(maxProfit,preProfit[i] + postProfit[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {3,8,5,1,7,8};
        System.out.println(getMaxProfit(a));
    }
}
