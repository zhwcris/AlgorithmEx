import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/12
 */
public class RangeSumQueryImmutable {

    private int[] accSum;
    public RangeSumQueryImmutable(int[] nums) {
        if(nums == null)return;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        accSum = nums;
    }

    public int sumRange(int i, int j) {
        if(accSum == null || accSum.length == 0)return 0;
        if(i == 0)return accSum[j];
        return accSum[j] - accSum[i-1];
    }
}
