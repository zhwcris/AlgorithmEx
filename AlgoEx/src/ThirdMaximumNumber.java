/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/12
 */
public class ThirdMaximumNumber  {
    public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = max1, max3 = max1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE){
                flag = true;
                continue;
            }
            if(nums[i] == max1 || nums[i] == max2){
                continue;
            }
            if(max1 < nums[i]){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(max2 < nums[i]){
                max3 = max2;
                max2 = nums[i];
            }else if(max3 < nums[i]){
                max3 = nums[i];
            }
        }
        if(flag == true){
           if(max3 == Integer.MIN_VALUE && max2 == max3){
               max3 = max1;
           }
        }else {
            max3 = max3 == Integer.MIN_VALUE ? max1 : max3;
        }
        return max3;
    }

    public int thirdMax2(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
