/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/6
 */
public class PalindromePartitioning2 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i-1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i-j) == s.charAt(i+j); j++) {
                dp[i+j+1] = Math.min(dp[i+j+1], 1 + dp[i-j]);
            }
            for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i-j+1) == s.charAt(i+j) ; j++) {
                dp[i+j+1] = Math.min(dp[i+j+1], 1 + dp[i-j+1]);
            }
        }
        return dp[n];
    }

    public int minCut1(String s) {
        int n = s.length(), min;
        int[] dp = new int[n];
        boolean[][] isPail = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            min = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || isPail[j+1][i-1])){
                    min = j == 0 ? 0 : Math.min(min, dp[j-1]+1);
                    isPail[j][i] = true;
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}
