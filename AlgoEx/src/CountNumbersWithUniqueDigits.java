/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/1
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10)n = 10;
        return dfs(n, new boolean[10], 0);
    }

    private int dfs(int n, boolean[] used, int now){
        if(now == n){
            return 1;
        }
        int total = 1;
        for (int i = now == 0 ? 1 : 0; i <= 9; i++) {
            if(!used[i]){
                used[i] = true;
                total += dfs(n, used, now+1);
                used[i] = false;
            }
        }
        return total;
    }

    public int countNumbersWithUniqueDigits1(int n) {
        if(n == 0)return 1;
        int res = 10, cur = 9, canUseNum = 9;
        while (n-- > 1 && canUseNum > 0){
            cur *= canUseNum;
            res += cur;
            canUseNum--;
        }
        return res;
    }
}
