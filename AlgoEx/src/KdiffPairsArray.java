import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/17
 */
public class KdiffPairsArray {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0)return 0;
        int res = 0, right, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            right = n - 1;
            while (i < right){
                if(nums[right] - nums[i] == k){
                    res++;
                    break;
                }else if(nums[right] - nums[i] < k){
                    break;
                }
                right--;
            }
        }
        return res;
    }

        public int findPairs1(int[] nums, int k) {
            if(nums == null || nums.length == 0 || k < 0)return 0;
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Integer> entry = iterator.next();
                if(k == 0){
                    if(entry.getValue() >= 2){
                        res++;
                    }
                }else {
                    if(map.containsKey(entry.getKey()+k)){
                        res++;
                    }
                }
            }
            return res;
        }

    public int findPairs2(int[] nums, int k) {
        if(nums == null || nums.length == 0)return 0;
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n; i++) {
            for(j = Math.max(i + 1, j); j < n && nums[j] - nums[i] < k; j++);
            if(j < n && nums[j] - nums[i] == k)res++;
            while (i + 1 < n && nums[i] == nums[i+1])i++;
        }
        return res;
    }
}
