package DP;

import java.util.Stack;

/**
 * Created by lwy on 2016/9/4.
 */
public class LargestRctangleArea {
    private static int countArea(int[] A, int n) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                int cur = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, A[cur] * (i - left - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, A[cur] * (n - left - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 9, 4, 1};
        System.out.println(countArea(a, 5));
    }
}
