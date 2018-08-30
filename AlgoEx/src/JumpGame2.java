import javax.print.attribute.standard.NumberUp;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/24
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int jump = 0;
        int nowFathestReach = 0;
        int lastFathestReach = 0;
        for (int i = 0; i < nums.length-1; i++) {
            nowFathestReach = Math.max(nowFathestReach,i + nums[i]);
            if(i == lastFathestReach){
                jump++;
                lastFathestReach = nowFathestReach;
            }
        }
        return jump;
    }

    public int jump1(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int i = 0, jump = 0, nowFathestReach = 0, lastFathestReach = 0;
        while(i <= lastFathestReach){
            jump++;
            for(; i <= lastFathestReach; i++){
                nowFathestReach = Math.max(nowFathestReach,i + nums[i]);
                if(nowFathestReach >= nums.length - 1)return jump;
            }
            lastFathestReach = nowFathestReach;
        }
        return 0;
    }

    public int jump3(int[] nums) {
        int i = 0;
        int jump = 0;
        int nowFathestReach = 0;
        int lastFathestReach = 0;
        while(i < nums.length){
            for(; i <= lastFathestReach; i++){
                nowFathestReach = Math.max(nowFathestReach,i + nums[i]);
            }
            lastFathestReach = Math.min(nowFathestReach, nums.length-1);
            jump++;

        }
        return jump-1;
    }
}
