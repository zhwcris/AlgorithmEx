/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/29
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int index = -1, sumL = 0, sumR = 0;
        for (int i = 0; i < nums.length; i++) {
            sumR += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            sumR -= nums[i];
            if(sumL == sumR)return i;
            sumL += nums[i];
        }
        return index;
    }
}
