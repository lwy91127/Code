package DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Created by lwy on 2016/6/14.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            int n = triangle.get(i).size();
            for (int j = n - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[0] + triangle.get(i).get(j);
                } else if (j == n - 1) {
                    dp[j] = dp[n - 2] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            if (num < min)
                min = num;
        }
        return min;
    }

    private void display(int[] dp) {
        for (int n : dp) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    @Test
    public void test() {
        List<Integer> a1 = new ArrayList<Integer>() {{
            add(2);
        }};
        List<Integer> a2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};
        List<Integer> a3 = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }};
        List<Integer> a4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};
        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
            add(a1);
            add(a2);
            add(a3);
            add(a4);
        }};
        System.out.println(minimumTotal(triangle));
    }
}
