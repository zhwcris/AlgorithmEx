/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/30
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[j] = pre;
                }else {
                    dp[j] = Math.min(pre + 1, Math.min(dp[j-1] + 1, dp[j] + 1));
                }
                pre = tmp;
            }
        }
        return dp[n];
    }

    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    dp[i][j]++;
                }
            }
        }
        return dp[m][n];
    }
}
