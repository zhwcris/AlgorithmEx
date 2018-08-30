/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/25
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean res = true;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                res = false;
                count++;
                if(count >= 2)return false;
                if((i - 1 < 0 || nums[i-1] <= nums[i+1] ) || (i + 2 >= nums.length || nums[i] <= nums[i+2])){
                    res = true;
                }
            }
        }
        return res;
    }
    public boolean checkPossibility1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                count++;
                if(i - 1 < 0 || nums[i-1] <= nums[i+1]){
                    nums[i] = nums[i+1];
                }else {
                    nums[i+1] = nums[i];
                }
            }
        }
        return count <= 1;
    }

    public boolean checkPossibility3(int[] a) {
        int modified = 0;
        for (int i = 1, prev = a[0]; i < a.length; i++) {
            if (a[i] < prev) {
                if (modified++ > 0) return false;
                if (i - 2 >= 0 && a[i - 2] > a[i]) continue;
            }
            prev = a[i];
        }
        return true;
    }

    public boolean checkPossibility2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (!(nums[i] <= nums[i + 1])) {
                if (count > 0)
                    return false;
                if (i - 1 >= 0 && i + 2 < nums.length && (nums[i] > nums[i + 2] && nums[i + 1] < nums[i - 1]))
                    return false;
                count++;
            }
        return true;
    }
}
