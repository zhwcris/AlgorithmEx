import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result, left, right, sum;
        Arrays.sort(nums);
        result = nums[0] + nums[nums.length - 1] + nums[nums.length - 2];
        for (int i = nums.length - 1; i >= 2; i--) {
            left = 0;
            right = i - 1;
            while(left < right){
                sum = nums[left] + nums[right] + nums[i];
                result = Math.abs(result - target) > Math.abs(sum - target) ? sum : result;
                if(sum == target){
                    return sum;
                }
                if(sum > target){
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                }else if(sum < target){
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                }
            }
        }
        return result;
    }
}
