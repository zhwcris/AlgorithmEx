/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/5
 */
public class GuessNumberHigherLower2 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        int res = recursive(dp, 1, n);
        return res;
    }

    private int recursive(int[][] dp, int i, int j){
        if(i >= j)return 0;
        if(dp[i][j] != 0)return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], k + Math.max(recursive(dp, i, k-1), recursive(dp, k+1,j)));
        }
        if(i + 1 == j){
            dp[i][j] = i;
        }
        return dp[i][j];
    }
    public int getMoneyAmount1(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--){
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int max = Math.max(dp[i][k-1], dp[k+1][j]);
                    dp[i][j] = Math.min(dp[i][j], k + max);
                }
                if(i + 1 == j){
                    dp[i][j] = i;
                }
            }
        }
        return dp[1][n];
    }
}
