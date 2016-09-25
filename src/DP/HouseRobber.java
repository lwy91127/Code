package DP;

import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Created by lwy on 2016/5/30.
 */
public class HouseRobber {

    /**
     * 得到状态转移方程为
     * dp[i] = max(dp[i-1],dp[i-2]+nums[i]);
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 0)
            return 0;
        if (l == 1)
            return nums[0];
        int[] dp = new int[l];//初始化dp数组
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[l - 1];
    }

    public int rob2(int[] nums, int start, int end) {
        int l = end - start + 1;
        int[] dp = new int[l];//初始化dp数组
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[l - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(rob2(nums, 1, nums.length - 1), rob2(nums, 0, nums.length - 2));
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 1, 7, 9};
        System.out.println(rob(nums));
    }
}
