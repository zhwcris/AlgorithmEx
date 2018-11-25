import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        int used = 0;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        boolean res = dfs(maxChoosableInteger, desiredTotal, used, memo);
        return res;
    }

    private boolean dfs(int maxChoosableInteger, int desiredTotal, int used, HashMap<Integer, Boolean> memo){
        if(desiredTotal <= 0)return false;
        if(memo.containsKey(used))return memo.get(used);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            if((used & mask) == 0){//数字i没有用过
                used |= mask;
                if(!dfs(maxChoosableInteger, desiredTotal - i, used, memo)){
                    used ^= mask;
                    memo.put(used, true);
                    return true;
                }
                used ^= mask;
            }
        }
        memo.put(used, false);
        return false;
    }
}
