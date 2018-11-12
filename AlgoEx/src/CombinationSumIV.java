import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/7
 */
public class CombinationSumIV {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {//dp
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if(i - nums[j] >= 0){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public int combinationSum41(int[] nums, int target) {//dfs with memorization
        if(target == 0)return 1;
        if(target < 0)return 0;
        if(map.containsKey(target))return map.get(target);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += combinationSum41(nums, target - nums[i]);
        }
        map.put(target, count);
        return count;
    }

    public int combinationSum42(int[] nums, int target) {//dfs no memorization
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += combinationSum4(nums, target - nums[i]);
        }
        return count;
    }
}
