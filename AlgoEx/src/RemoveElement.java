/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/25
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int p1, p2 = 0;
        for(p1 = 0; p1 < nums.length; p1++){
            if(nums[p1] != val){
                nums[p2] = nums[p1];
                p2++;
            }
        }
        return p2;
    }
}
