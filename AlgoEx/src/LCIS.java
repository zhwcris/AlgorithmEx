/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/30
 */
public class LCIS {
    public int findLengthOfLCIS(int[] nums) {
        int len = 0, preLen = 0, maxLen = 0;
        int pre = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > pre){
                len = preLen + 1;
            }else {
                len = 1;
            }
            preLen = len;
            pre = nums[i];
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
