import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/11
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int n = nums.length, len = 1;
        int[] tail = new int[n];
        tail[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] > tail[len-1]){
                tail[len++] = nums[i];
            }else if(nums[i] < tail[0]){
                tail[0] = nums[i];
            }else {
                binarySearch(tail, len, nums[i]);
            }
        }
        return len;
    }

    private void binarySearch(int[] tail, int len, int key){
        int low = 0, high = len - 1, mid;
        while (low <= high){
            mid = (low + high) / 2;
            if(tail[mid] == key){
                return;
            }else if(tail[mid] < key){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        tail[low] = key;
    }


    public int lengthOfLIS1(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int n = nums.length, max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
