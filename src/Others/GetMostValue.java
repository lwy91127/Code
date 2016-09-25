package Others;

/**
 * Created by lwy on 2016/9/2.
 */
public class GetMostValue {
    private static int getMostValue(int[][] board) {
        int[] dp = new int[board[0].length];
        dp[0] = board[0][0];
        for (int j = 1; j < board[0].length; j++) {
            dp[j] = board[0][j] + dp[j - 1];
        }
        for (int i = 1; i < board.length; i++) {
            dp[0] += board[i][0];
            for (int j = 1; j < board[0].length; j++) {
                dp[j] = board[i][j] + Math.max(dp[j - 1], dp[j]);
            }
        }
        return dp[board[0].length - 1];
    }
}
