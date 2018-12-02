public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int l, r;
        for (int i = 0; i < n; i++) {
            for (l = i, r = i; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++)res++;
            for(l = i, r = i+1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++)res++;
        }
        return res;
    }

    public int countSubstrings1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
            for (int j = 0; j < i; j++) {
                dp[i][j] = s.charAt(j) == s.charAt(i) && (i-1 <= j+1 || dp[i-1][j+1]);
                if(dp[i][j])res++;
            }
        }
        return res;
    }
}
