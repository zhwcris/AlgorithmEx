import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/18
 */
public class ShortestContiSub {
    public int findUnsortedSubarray1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] numsSorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsSorted);
        while (left < nums.length && nums[left] == numsSorted[left])left++;
        while (right > left && nums[right] == numsSorted[right])right--;
        return right - left + 1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = 0, rigtht = nums.length - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (left < rigtht && nums[left] <= nums[left+1])left++;
        if(left == rigtht)return 0;
        while (left < rigtht && nums[rigtht-1] <= nums[rigtht])rigtht--;

        for (int i = left; i <= rigtht; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (left >= 0 && nums[left] > min)left--;
        while (rigtht < nums.length && max > nums[rigtht])rigtht++;
        return rigtht - left - 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 0 || nums.length == 1) return 0;

        int max = Integer.MIN_VALUE;
        int end = -2;
        //iterate from beginning of array
        //find the last element which is smaller than the last seen max from
        //its left side and mark it as end
        for(int i = 0; i < nums.length; i ++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max)
                end = i;
        }

        int min = Integer.MAX_VALUE;
        int begin = -1;
        //iterate from end of array
        //find the last element which is bigger than the last seen min from
        //its right side and mark it as begin
        for(int i = nums.length - 1; i >= 0; i --){
            min = Math.min(min, nums[i]);
            if(nums[i] > min)
                begin = i;
        }

        return end - begin + 1;

    }
}
