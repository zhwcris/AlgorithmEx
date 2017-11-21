public class ProductofArray {
    public int[] productExceptSelf(int[] nums) {
        int[] outPut = null;
        if(nums != null){
           outPut = new int[nums.length];
           outPut[0] = 1;
           int tmp = 1;
           for(int i = 1; i < nums.length; i++){
               outPut[i] = outPut[i-1] * nums[i-1];
           }

           for(int i = nums.length - 1; i >= 0; i--){
               outPut[i] *= tmp;
               tmp *= nums[i];
           }
        }
        return outPut;
    }
}
