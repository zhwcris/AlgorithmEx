/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/26
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        boolean res = canWin(nums, 0, nums.length-1, 0, 0);
        return res;
    }

    public boolean PredictTheWinner2(int[] nums) {
        boolean res = helper(nums, 0, nums.length-1)>=0;
        return res;
    }
    private int helper(int[] nums, int s, int e){
        return s==e ? nums[e] : Math.max(nums[e] - helper(nums, s, e-1), nums[s] - helper(nums, s+1, e));
    }
    private boolean canWin(int[] nums, int left, int right, int fistScore, int secondScore){
        // assume fistScore is the score of current player (to pick in this round)
        if(left > right){
            return fistScore >= secondScore;
        }
        fistScore += nums[left++]; //  pick left
        if(!canWin(nums, left, right, secondScore, fistScore)){
            // check if next player can win. if next player cannot win, return true, which means the current player can win
            return true;
        }
        // backtrack
        left--;
        fistScore -= nums[left];
        // pick right;
        fistScore += nums[right--];
        if(!canWin(nums, left, right, secondScore, fistScore)){
            //check if next player can win
            return true;
        }
        right++;
        fistScore -= nums[right];
        return false;
    }


    public boolean PredictTheWinne1(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        boolean res = dfs(nums, 0, nums.length-1,true, 0, 0);
        return res;
    }

    private boolean dfs(int[] nums, int start, int end, boolean b, int s1, int s2){
        if(start > end){
            return s1 > s2 || b && s1 == s2;
        }
        return !dfs(nums, start+1, end, !b ,s2, s1+nums[start]) || !dfs(nums, start, end-1, !b, s2, s1+nums[end]);
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
