/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/27
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j <= n; j++) {
            for (int i = j-1; i >= 1; i--) {
                if(s.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[1][n];
    }
}
