import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/29
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i, k;
        for (i = nums.length - 1; i >= 1; i--) {
            if(nums[i] > nums[i-1]){
                break;
            }
        }

        if(i == 0){
            reverseSort(nums, 0);
            return;
        }
        k = i - 1;
        for(int j = i; j < nums.length; j++){
            if(nums[j] > nums[i-1]){
                k = j;
            }
        }
        int tmp = nums[i-1];
        nums[i-1] = nums[k];
        nums[k] = tmp;
        reverseSort(nums, i);
    }

    private void reverseSort(int[] nums, int index){
        int tmp, start = index, end = nums.length - 1;
        while (start < end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
