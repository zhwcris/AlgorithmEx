public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        int[] accSum = new int[n+1];
        accSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            accSum[i] = accSum[i-1] + A[i-1];
        }
        double[][] dp = new double [n+1][K+1];
        double res = dfs(accSum, 0, n, K, dp);
        return res;
    }

    private double dfs(int[] accSum, int start, int n, int k, double[][] dp){
        if(k == 1)return (accSum[n] - accSum[start] * 1.0) / (n - start);
        if(dp[start][k] != 0)return dp[start][k];
        double max = 0;
        for (int i = start + 1; i <= n - (k - 1); i++) {
            double cur = (accSum[i] - accSum[start]) * 1.0 / (i - start) + dfs(accSum, i, n, k-1, dp);
            max = Math.max(max, cur);
        }
        dp[start][k] = max;
        return max;
    }
}
