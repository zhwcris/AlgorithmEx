/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/25
 */
public class RemoveDupInSorted {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 1, lastIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[lastIndex] != nums[i]){
                result++;
                lastIndex++;
                nums[lastIndex] = nums[i];
            }
        }
        return result;
    }
}
