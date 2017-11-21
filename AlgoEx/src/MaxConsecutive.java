public class MaxConsecutive {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(cur > max){
                    max = cur;
                }
                cur = 0;
            }else {
                cur++;
            }
        }
        if(max < cur){
            max = cur;
        }
        return max;
    }
}
