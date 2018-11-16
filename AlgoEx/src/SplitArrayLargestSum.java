/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/16
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] accSum = new int[n];
        accSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            accSum[i] = accSum[i-1] + nums[i];
        }


        return 0;
    }
}
