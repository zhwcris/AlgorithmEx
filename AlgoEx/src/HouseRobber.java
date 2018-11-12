/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/7
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[n];
    }

    public int rob1(int[] nums) {
        int pre1 = 0, pre2 = 0, tmp, n = nums.length;
        for (int i = 0; i < n; i++) {
            tmp = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = tmp;
        }
        return pre2;
    }
}
