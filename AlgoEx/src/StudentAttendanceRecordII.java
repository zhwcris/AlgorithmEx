public class StudentAttendanceRecordII {//  same with Non-negative Integers without Consecutive Ones利用好 end with some dp[i]

    static final int mod = (int) (1e9+7);
    public int checkRecord(int n){// first solution
        long[] P = new long[n+1]; //end with P w/o A
        long[] L = new long[n+1]; //end with L w/o A
        P[0] = P[1] = L[1] = 1;
        for(int i = 2; i <= n; i++){
            P[i] = (P[i-1] + L[i-1]) % mod;
            L[i] = (P[i-1] + P[i-2]) % mod;
        }
        long res = (P[n] + L[n]) % mod;
        //insert A
        for(int i = 0; i < n; i++){
            long s = ((P[i] + L[i])%mod * (P[n-i-1] + L[n-i-1])%mod )% mod;
            res = (res + s) % mod;
        }
        return (int) res;
    }

    /**
     *  -----+---------------
     * 	 INIT | A -- L -- P --
     * 	 -----+---------------
     * 	 A0L0 | A1L0 A0L1 A0L0
     * 	 A0L1 | A1L0 A0L2 A0L0
     * 	 A0L2 | A1L0 Done A0L0
     * 	 A1L0 | Done A1L1 A1L0
     * 	 A1L1 | Done A1L2 A1L0
     * 	 A1L2 | Done Done A1L0
     * @param n
     * @return
     */
    public int checkRecord2(int n) {// solution2
        int[] dp = { 1, 1, 0, 1, 0, 0 }; // init table for n = 1
        for (int i = 2; i <= n; i++) // updating table for n = i
            dp = new int[] { sum(dp, 0, 2), dp[0], dp[1], sum(dp, 0, 5), dp[3], dp[4] };
        return sum(dp, 0, 5);
    }

    static int sum(int[] arr, int l, int h) {
        int s = 0;
        for (int i = l; i <= h; i++)
            s = (s + arr[i]) % 1000000007;
        return s;
    }
}
