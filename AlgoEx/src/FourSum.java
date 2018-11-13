import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int left, right, sum;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 3; i--){
            if(i==nums.length - 1 || nums[i]!=nums[i+1]){
                for (int j = i - 1; j >= 2; j--) {
                    if(j==i - 1 || nums[j]!=nums[j+1]){
                        left = 0;
                        right = j - 1;
                        while(left < right){
                            sum = nums[left] + nums[right] + nums[j] + nums[i];
                            if(sum == target){//check if equals target and not duplicated
                                result.add(Arrays.asList(nums[left], nums[right], nums[j], nums[i]));
                                while(left < right && nums[right] == nums[right-1]){
                                    right--;
                                }
                                right--;
                                left++;
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
                }
            }
        }
        return result;
    }

}
