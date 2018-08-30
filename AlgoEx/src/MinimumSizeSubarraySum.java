/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/24
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE, p1 = 0, p2 = 0, curSum = 0;
        while (p2 < nums.length){
            curSum += nums[p2];
            if(curSum > s){
                while (curSum - nums[p1] >= s){
                    curSum -= nums[p1];
                    p1++;
                }
                min = Math.min(p2 - p1 + 1, min);
            }
            p2++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int min = Integer.MAX_VALUE, p1 = 0, p2 = 0, curSum = 0;
        while (p2 < nums.length){
            curSum += nums[p2];
            while(curSum >= s){
                min = Math.min(p2 - p1 + 1, min);
                curSum -= nums[p1];
                p1++;
            }
            p2++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
