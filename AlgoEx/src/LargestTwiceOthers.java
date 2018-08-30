/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/29
 */
public class LargestTwiceOthers {
    public int dominantIndex(int[] nums) {
        int res = 0, lessMax = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                lessMax = max;
                max = nums[i];
                res = i;
            }else if(nums[i] < max && nums[i] > lessMax){
                lessMax = nums[i];
            }
        }
        return lessMax * 2 <= max ? res : -1;
    }
}
