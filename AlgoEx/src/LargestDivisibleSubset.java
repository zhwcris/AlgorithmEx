import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/8
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {//thought by myself ||| used parent cache be careful
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)return res;
        Arrays.sort(nums);
        int n = nums.length, max = 0, index = 0;
        int[] dp = new int[n];
        int[] pre = new int[n];//parent cache
        for(int i = n - 1; i >= 0; i--){
            for (int j = n - 1; j > i; j--) {
                if(nums[j] % nums[i] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        for (int i = 0; i <= max; i++) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
