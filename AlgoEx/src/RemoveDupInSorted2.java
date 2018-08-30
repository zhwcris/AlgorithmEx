/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/25
 */
public class RemoveDupInSorted2 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = 1, lastIndex = 0, numberCount = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[lastIndex] == nums[i]){
                if(numberCount < 2){
                    lastIndex++;
                    nums[lastIndex] = nums[i];
                }
                numberCount++;
            }else {
                lastIndex++;
                nums[lastIndex] = nums[i];
                numberCount = 1;
            }
            if(numberCount <= 2){
                result++;
            }
        }
        return result;
    }
}
