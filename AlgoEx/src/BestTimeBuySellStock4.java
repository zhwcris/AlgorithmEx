/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/6
 */
public class BestTimeBuySellStock4 {
    public int maxProfit(int d, int[] prices) {
        int n = prices.length;
        if(n <= 1)return 0;
        if(d >= n / 2)return quickSolve(prices);
        int[][] dp = new int[d+1][n];
        for (int k = 1; k <= d; k++) {
            int max = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i-1], max + prices[i]);
                max = Math.max(max, dp[k-1][i-1] - prices[i]);
            }
        }
        return dp[d][n-1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    public int maxProfit1(int d, int[] prices) {
        int n = prices.length;
        if(n <= 1)return 0;
        int[][] dp = new int[d+1][n];
        for (int k = 1; k <= d; k++) {
            for (int i = 1; i < n; i++) {
                int max = -prices[0];
                for (int j = 1; j <= i; j++) {
                    max = Math.max(max, dp[k-1][j-1] - prices[j]);
                }
                dp[k][i] = Math.max(dp[k][i-1], max + prices[i]);
            }
        }
        return dp[d][n-1];
    }
}
