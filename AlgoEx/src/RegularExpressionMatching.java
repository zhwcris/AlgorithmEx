/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/10/30
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2] || (i > 0) && (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) && dp[i-1][j];
                }else {
                    dp[i][j] = (i > 0) && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch2(String s, String p) {
        return recursive(s, 0, p, 0);
    }

    private boolean recursive(String s, int si, String p, int pi){
        if(pi == p.length()){
            return si == s.length();
        }
        if(pi + 1 < p.length() && p.charAt(pi + 1) == '*'){
            return recursive(s, si, p, pi + 2) || (si < s.length() && (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi)) && recursive(s, si + 1, p, pi));
        }else {
            return si < s.length() && (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi)) && recursive(s, si+1, p, pi+1);
        }
    }
}
