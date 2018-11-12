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

    /**
     * public int maxProduct(int[] nums) {
     int max = Integer.MIN_VALUE, product = 1;
     int len = nums.length;

     for(int i = 0; i < len; i++) {
     max = Math.max(product *= nums[i], max);
     if (nums[i] == 0) product = 1;
     }

     product = 1;
     for(int i = len - 1; i >= 0; i--) {
     max = Math.max(product *= nums[i], max);
     if (nums[i] == 0) product = 1;
     }

     return max;
     }
     */
}
