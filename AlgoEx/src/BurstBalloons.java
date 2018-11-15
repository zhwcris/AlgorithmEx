import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/15
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        int[] newArray = new int[n+2];
        newArray[0] = 1;
        newArray[n+1] = 1;
        for (int i = 0; i < n; i++) {
            newArray[i+1] = nums[i];
        }
        int[][] dp = new int[n+1][n+1];
        int res = dfs(newArray, 1, n, dp);
        return res;
    }
    
    private int dfs(int[] nums, int left, int right, int[][] dp){//dividing the problem into tow sub problems by the last balloon to burst
        if(left > right)return 0;
        if(dp[left][right] > 0)return dp[left][right];
        for (int i = left; i <= right; i++) {
            dp[left][right] = Math.max(dp[left][right], dfs(nums, left, i-1, dp)
                    + nums[left-1] * nums[i] * nums[right+1] + dfs(nums, i+1, right, dp));
        }
        return dp[left][right];
    }
}
