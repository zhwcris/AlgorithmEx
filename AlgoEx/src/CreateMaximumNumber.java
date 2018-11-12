/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/14
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int m = nums1.length, n = nums2.length;
        int min = Math.max(k - m, 0);
        for (int i = min; i <= k && i <= n; i++) {
            int[] tmp = mergeTowMaxArray(maxSubArray(nums1, k - i), maxSubArray(nums2, i), k);
            if(comareToArray(tmp, 0, res, 0)){
                res = tmp;
            }
        }
        return res;
    }

    private int[] mergeTowMaxArray(int[] nums1, int[] nums2, int k){
        int[] res = new int[k];
        for (int i = 0, i1 = 0, i2 = 0; i < k; i++){
            if(comareToArray(nums1, i1, nums2, i2)){
                res[i] = nums1[i1++];
            }else{
                res[i] = nums2[i2++];
            }
        }
        return res;
    }

    private boolean comareToArray(int[] nums1, int i, int[] nums2, int j){
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxSubArray(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[k];
        int last = -1;
        for (int i = 0; i < k; i++) {
            for (int j = last + 1; j + (k - i - 1) < n; j++) {
                if(res[i] < nums[j]){
                    res[i] = nums[j];
                    last = j;
                }
            }
        }
        return res;
    }
}
