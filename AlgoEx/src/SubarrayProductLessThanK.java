/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/29
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length == 0 || nums == null)return 0;
        int res = 0, product = 1;
        for (int j = 0, i = 0; j < nums.length; j++) {
            product *= nums[j];
            while (i < j && product >= k)product /= nums[i++];
            if(product < k){
                res += j - i + 1;
            }
        }
        return res;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {//TLE
        if(nums.length == 0 || nums == null)return 0;
        int res = 0, product;
        for (int i = 0; i < nums.length; i++) {
            product = nums[i];
            if(product < k){
                res++;
            }else {
                continue;
            }
            for(int j = i+1; j < nums.length; j++){
                product *= nums[j];
                if(product < k){
                    res++;
                }else {
                    break;
                }
            }
        }
        return res;
    }
}
