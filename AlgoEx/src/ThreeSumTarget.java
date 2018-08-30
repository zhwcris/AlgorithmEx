import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/10
 */
public class ThreeSumTarget {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int target, left, right, pre = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0){
                break;
            }
            if(pre != -1 && nums[pre] == nums[i]){
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            target = 0 - nums[i];
            while (left < right){
                if(target == nums[left] + nums[right]){
                    List<Integer> list = Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]});
                    result.add(list);
                    while (left < right && nums[left] == nums[left+1])left++;
                    while(left < right && nums[right] == nums[right-1])right--;
                    left++;
                    right--;
                }else if(target < nums[left] + nums[right]){
                    right--;
                }else {
                    left++;
                }
            }
            pre = i;
        }
        return result;
    }
}
