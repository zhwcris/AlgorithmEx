/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/6
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]){
                up = down + 1;
            }else if(nums[i] < nums[i-1]){
                down = up + 1;
            }
        }
        return Math.min(n, Math.max(up, down));
    }

    public int wiggleMaxLength1(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int len = 1, i = 1, mark = 0;
        while (i < nums.length){
            while (i < nums.length && nums[i] >= nums[i-1])i++;
            if(nums[mark] != nums[i-1])len++;
            mark = i-1;
            while (i < nums.length && nums[i] <= nums[i-1])i++;
            if(nums[mark] != nums[i-1])len++;
            mark = i-1;
        }
        return len;
    }
}
