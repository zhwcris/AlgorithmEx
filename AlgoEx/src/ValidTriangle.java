import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/19
 */
public class ValidTriangle {
    public int triangleNumber(int[] nums) {
        int count = 0, left, right;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0; i--){
            left = 0;
            right = i-1;
            while (left < right){
                if(nums[left] + nums[right] > nums[i]){
                    count += right - left;
                    right--;
                }else {
                    left++;
                }
            }
        }
        return count;
    }

    public int triangleNumber1(int[] A) {
        Arrays.sort(A);
        int count = 0, n = A.length;
        for (int i=n-1;i>=2;i--) {
            int l = 0, r = i-1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r-l;
                    r--;
                }
                else l++;
            }
        }
        return count;
    }
}
