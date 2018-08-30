/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/24
 */
public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum;
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        maxSum = curSum;
        for(int i = k; i < nums.length; i++){
            curSum += nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum / k;
    }
}
