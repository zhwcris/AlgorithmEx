/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/15
 */
public class FindMinRotaedSortedArray {
    public int findMin(int[] nums) {
        int min = nums[0], low = 0, high = nums.length - 1, mid;
        while (low < high){
           if(high - low == 1){
               return Math.min(nums[low], nums[high]);
           }
           mid = (low + high)/2;
           if(nums[mid] > nums[high]){
               low = mid;
           }else if(nums[mid] < nums[high]){
               high = mid;
           }
        }
        return min;
    }
}
