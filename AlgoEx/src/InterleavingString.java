/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/4
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n1 + n2 != n3)return false;
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            dp[i][0] =  s1.charAt(i-1) == s3.charAt(i-1);
            if(!dp[i][0])break;
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1);
            if(!dp[0][j])break;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]
                        || s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1];
            }
        }
        return dp[n1][n2];
    }
    
    public boolean isInterleave1(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n1 + n2 != n3)return false;
        return dfsCheck(s1, s2, s3, 0, 0, 0, new boolean[n1+1][n2+1]);
    }

    private boolean dfsCheck(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid){
        if(invalid[i][j]) return false;
        if(k == s3.length())return true;
        boolean valid = (i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfsCheck(s1, s2, s3, i+1, j, k+1, invalid))
                || (j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfsCheck(s1, s2, s3, i, j+1, k+1, invalid));
        if(!valid)invalid[i][j] = true;
        return valid;
    }

}
