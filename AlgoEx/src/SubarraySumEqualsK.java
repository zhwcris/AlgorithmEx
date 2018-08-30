import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/18
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)return 0;
        int res = 0, n = nums.length, sum;
        for (int i = 0; i < n; i++) {
            sum = nums[i];
            if(sum == k){
                res++;
            }
            for (int j = i + 1; j < n; j++){
                sum += nums[j];
                if(sum == k){
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum1(int[] nums, int k) {
        if(nums == null || nums.length == 0)return 0;
        int res = 0, n = nums.length, sum = 0, key;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            key = sum - k;
            if(map.containsKey(key)){
                res += map.get(key);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
