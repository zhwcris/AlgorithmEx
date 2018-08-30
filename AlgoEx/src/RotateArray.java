/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/23
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k == 0){
            return;
        }
        int p1 = 0, p2 = nums.length - k, tmp, start = p2, last = nums.length;
        while (p1 < p2){
            tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
            p1++;
            p2++;
            if (p2 == last) {
                p2 = start;
            }else if(p1 == start) {
                start = p2;
            }
        }
    }
}
