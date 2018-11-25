public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if((S + sum) % 2 > 0  || S > sum)return 0;

        return subsetSum(nums, (S+sum)/2);
    }

    //Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    public int findTargetSumWays1(int[] nums, int S) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(S < -sum || S > sum)return 0;
        int m = 2*sum+1;
        int[][] dp = new int[n+1][m];
        dp[0][0+sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if(j - nums[i-1] >= 0){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
                if(j + nums[i-1] < m){
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                }
            }
        }
        return dp[n][sum + S];
    }

}
