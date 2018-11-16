/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/16
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums == null)return false;
        int n = nums.length;
        if(nums.length <= 1)return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0)return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {//和PerfectSquares CoinChange WordBreak CombinationSumIV的方法很详细， 这里注意里面的循环的遍历顺序，因为有1并且num[i]使用次数有限，要从后往前遍历
            //https://www.cnblogs.com/fengziwei/p/7750849.html   这里有详细解释为何  “倒过来”  遍历
//            for (int j = 1; j <= sum; j++) {
//                if(nums[i] <= j){
//                    dp[i] = dp[j] || dp[j - nums[i]];
//                }
//            }
            for (int j = sum; j >= 1; j--) {
                if(nums[i] <= j && dp[j - nums[i]]){
                    dp[j] = true;
                }
            }
        }
        return dp[sum];
    }
}
