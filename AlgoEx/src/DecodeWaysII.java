public class DecodeWaysII {
    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;
        for (int i = 2; i <= n; i++) {
            if(s.charAt(i-2) != '*'){
                if(s.charAt(i-1) != '*'){
                    int f = Integer.valueOf(s.substring(i-1, i));
                    int f1 = Integer.valueOf(s.substring(i-2, i));
                    if(f >= 1 && f <= 9)dp[i] += dp[i-1];
                    if(f1 >= 10 && f1 <= 26)dp[i] += dp[i-2];
                }else {
                    dp[i] += 9*dp[i-1];
                    if(s.charAt(i-2) == '1')dp[i] += dp[i-2] * 9;
                    if(s.charAt(i-2) == '2')dp[i] += dp[i-2] * 6;
                }
            }else {
                if(s.charAt(i-1) != '*'){
                    if(s.charAt(i-1) != '0')dp[i] += dp[i-1];
                    if(s.charAt(i-1) <= '6'){
                        dp[i] += 2*dp[i-2];
                    }else {
                        dp[i] += dp[i-2];
                    }
                }else {
                    dp[i] += 9*dp[i-1];
                    dp[i] += dp[i-2] * 15;
                }

            }
            dp[i] %= 1000000007;
        }
        return (int) dp[n];
    }
}
