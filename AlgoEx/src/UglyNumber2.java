/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/9
 */
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, v2, v3, v5;
        for (int i = 1; i < n; i++){
            v2 = 2 * nums[t2];
            v3 = 3 * nums[t3];
            v5 = 5 * nums[t5];
            nums[i] = Math.min(v2, Math.min(v3, v5));
            if(v2 == nums[i])t2++;
            if(v3 == nums[i])t3++;
            if(v5 == nums[i])t5++;
        }
        return nums[n-1];
    }
}
