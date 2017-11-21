public class MajorityElement {
    public int majorityElement(int[] nums) {
        int result = nums[0],count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                count++;
                result = nums[i];
            }else if(result == nums[i]){
                count++;
            }else count--;
        }
        return result;
    }
}
