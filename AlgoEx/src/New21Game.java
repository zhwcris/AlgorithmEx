public class New21Game {
    public double new21Game(int N, int K, int W) {//DP SOLUTION1
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i]; else res += dp[i];
            if (i - W >= 0) Wsum -= dp[i - W];
        }
        return res;
    }

    public double new21Game1(int N, int K, int W) {//dp solution2
        if (K == 0) {
            return 1;
        }
        int max = K + W - 1;
        double[] dp = new double[max + 1];
        dp[0] = 1;
        for (int i = 1; i <= max; i++) {
            dp[i] = dp[i - 1];
            if (i <= W) {
                dp[i] += dp[i - 1] / W;
            } else {
                dp[i] += (dp[i - 1] - dp[i - W - 1]) / W;
            }
            if (i > K) {
                dp[i] -= (dp[i - 1] - dp[K - 1]) / W;
            }
        }
        return dp[N] - dp[K - 1];
    }


}
