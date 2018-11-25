public class OnesAndZeroes {
    // dp[i][j] = the max number of strings that can be formed with i 0's and j 1's
    //和PerfectSquares CoinChange WordBreak CombinationSumIV  OnesAndZeros 的方法很详细， 这里注意里面的循环的遍历顺序，因为有1并且num[i]使用次数有限，要从后往前遍历
    //https://www.cnblogs.com/fengziwei/p/7750849.html   这里有详细解释为何  “倒过来”  遍历
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0)return 0;
        int len = strs.length, num0, num1;
        int[][] dp = new int[m+1][n+1];
        for (int k = 0; k < len; k++) {
            String s = strs[k];
            num0 = 0;
            num1 = 0;
            for (int p = 0; p < s.length(); p++) {
                if(s.charAt(p) == '0'){
                    num0++;
                }else {
                    num1++;
                }
            }
            for (int i = m; i >= num0; i--) {
                for (int j = n; j >= num1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-num0][j-num1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
