/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/23
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int tmp;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++){
            tmp = Math.abs(nums[i]);
            if(tmp <= nums.length){
                nums[tmp-1] = nums[tmp-1] < 0 ? nums[tmp-1] : -nums[tmp-1];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int low = -1, tmp, length;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                low++;
                if(low != i){
                   tmp = nums[i];
                   nums[i] = nums[low];
                   nums[low] = tmp;
                }
            }
        }
        length = low + 1;
        for (int i = 0; i < length; i++){
            tmp = Math.abs(nums[i]);
            if(tmp <= length){
                nums[tmp-1] = nums[tmp-1] < 0 ? nums[tmp-1] : -nums[tmp-1];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return length + 1;
    }
}
