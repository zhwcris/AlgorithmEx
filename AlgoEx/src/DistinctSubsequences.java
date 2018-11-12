import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/5
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        if(n < m)return 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + (s.charAt(j-1) == t.charAt(i-1) ? dp[i-1][j-1] : 0);
            }
        }
        return dp[m][n];
    }

    public int numDistinct2(String s, String t) {
        if(s.length() < t.length())return 0;
        int[][] cache = new int[s.length()][t.length()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        int res = dfsCount2(s, t, 0, 0, cache);
        return res;
    }

    private int dfsCount2(String s, String s1, int start, int k, int[][] cache){
        if(k == s1.length())return 1;
        if(start >= s.length())return 0;
        if(cache[start][k] != -1)return cache[start][k];
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            if(s.charAt(i) == s1.charAt(k)){
                count += dfsCount2(s, s1, i+1, k+1, cache);
            }
        }
        cache[start][k] = count;
        return count;
    }

    public int numDistinct1(String s, String t) {
        int res = 0;
        if(s.length() < t.length())return 0;
        for (int i = 0; i < s.length(); i++) {
            res += dfsCount1(s, t, i, 0);
        }
        return res;
    }

    private int dfsCount1(String s, String s1, int start, int k){
        int count = 0;
        if(s.charAt(start) == s1.charAt(k)){
            if(k == s1.length() -1)return 1;
            for (int i = start; i < s.length(); i++) {
                count += dfsCount1(s, s1, i, k+1);
            }
        }
        return count;
    }
}
