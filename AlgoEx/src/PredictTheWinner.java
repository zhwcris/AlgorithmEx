/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/26
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        boolean res = dfs1(nums, 0, nums.length - 1, true,0, 0);
        return res;
    }

    public boolean PredictTheWinne1(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        boolean res = dfs(nums, 0, nums.length-1, 0, 0);
        return res;
    }

    private boolean dfs(int[] nums, int start, int end, int s1, int s2){
        if(start > end){
            return s1 >= s2;
        }
        return !dfs(nums, start+1, end, s2, s1+nums[start]) || !dfs(nums, start, end-1, s2, s1+nums[end]);
    }

    private boolean dfs1(int[] nums, int start, int end, boolean b, int s1, int s2){//傻瓜式写法
        if(start > end){
            if(b){
                return s1 >= s2;
            }else {
                return s1 < s2;
            }
        }
        if(b){
            return !dfs1(nums, start+1, end, !b, s1+nums[start], s2) || !dfs1(nums, start, end-1, !b, s1+nums[end], s2);
        }else {
            return !dfs1(nums, start+1, end, !b, s1, s2+nums[start]) || !dfs1(nums, start, end-1, !b, s1, s2+nums[end]);
        }
    }
}
