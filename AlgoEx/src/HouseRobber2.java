/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/9
 */
public class HouseRobber2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)return nums[0];
        return Math.max(rob(nums, 0, n-2), rob(nums,1, n-1));
    }

    public int rob(int[] nums, int start, int end) {
        int pre1 = 0, pre2 = 0, tmp;
        for (int i = start; i <= end; i++) {
            tmp = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = tmp;
        }
        return pre2;
    }
}
