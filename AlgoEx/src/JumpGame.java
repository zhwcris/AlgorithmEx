/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/24
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int index = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(index - i <= nums[i]){
                index = i;
            }
        }
        return index == 0;
    }
}
