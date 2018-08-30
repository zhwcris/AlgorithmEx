import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/24
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList();
        }
        int m1 = nums[0], m2 = m1, count1 = 0, count2 = 0;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == m1){
                count1++;
            }else if(nums[i] == m2){
                count2++;
            }else if(count1 == 0){
                m1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                m2 = nums[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == m1){
                count1++;
            }else if(nums[i] == m2){
                count2++;
            }
        }

        if(count1 > nums.length / 3)
            list.add(m1);
        if(count2 > nums.length / 3)
            list.add(m2);
        return list;
    }
}
