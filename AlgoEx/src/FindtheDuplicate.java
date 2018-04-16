/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/13
 */
public class FindtheDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
