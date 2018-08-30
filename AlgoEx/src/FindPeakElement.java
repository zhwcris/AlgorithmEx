/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/12
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int index = 0, n = nums.length;
        if(n == 1 || nums[0] > nums[1])return 0;
        if(nums[n-1] > nums[n-2])return n-1;
        for (int i = 1; i < n-1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                index = i;
                break;
            }
        }
        return index;
    }

    public int findPeakElement1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]){
                return i-1;
            }
        }
        return nums.length-1;
    }

    public int findPeakElement2(int[] nums) {
        int low = 0, high = nums.length-1, mid;
        while (low < high){
            mid = (low + high) / 2;
            if(nums[mid] < nums[mid+1]){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
