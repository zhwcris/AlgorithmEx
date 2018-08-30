import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/11
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean res = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)){
                res = true;
                break;
            }else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
