/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/9
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int maxEndi = max, minEndi = max, tmp;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                tmp = maxEndi;
                maxEndi = minEndi;
                minEndi = tmp;
            }
            maxEndi = Math.max(maxEndi * nums[i], nums[i]);
            minEndi = Math.min(minEndi * nums[i], nums[i]);
            max = Math.max(max, maxEndi);
        }
        return max;
    }
}
