import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/18
 */
public class CoinChange {

    int total = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {//dfs
        if (amount == 0) return 0;
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return total == Integer.MAX_VALUE ? -1 : total;
    }
    private void dfs(int[] coins, int amount, int index, int count){
        if(index < 0 || count >= total){
            return;
        }
        int c = amount / coins[index];
        for (int i = c; i >= 0; i--) {
            int newAmount = amount - coins[index] * i;
            int newCount = count + i;
            if(newAmount > 0 && newCount < total){
                dfs(coins, newAmount, index - 1, newCount);
            }else if(newCount < total){
                total = newCount;
            }else {
                break;
            }
        }
        return;
    }
//    void count(int amount, int index, int[] coins, int count){
//        if (index<0 || count>=total-1) return;
//        int c = amount/coins[index];
//        for (int i = c;i>=0;i--){
//            int newCount = count + i;
//            int rem = amount - i*coins[index];
//
//            if (rem>0 && newCount<total)
//                count(rem, index-1, coins, newCount);
//            else if (newCount<total)
//                total = newCount;
//            else if (newCount>=total-1)
//                break;
//        }
//    }

    public int coinChange3(int[] coins, int amount) {//bfs
        if(coins == null || coins.length == 0){
            return -1;
        }
        if(amount == 0)return 0;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        boolean[] visited = new boolean[amount+1];
        arrayDeque.add(amount);
        Arrays.sort(coins);
        int depth = 1, tmp = 0, perFloor = 1;
        while (!arrayDeque.isEmpty()){
            if(perFloor == 0){
                depth++;
                perFloor = tmp;
                tmp = 0;
            }
            int cur = arrayDeque.poll();
            perFloor--;
            for (int i = coins.length - 1; i >= 0; i--) {
                int sub = cur - coins[i];
                if(sub == 0){
                    return depth;
                }else if(sub > 0 && !visited[sub]){
                    arrayDeque.add(sub);
                    visited[sub] = true;
                    tmp++;
                }
            }
        }
        return -1;
    }

    public int coinChange2(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int pre;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                pre = j - coins[i];
                if(dp[pre] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[pre] + 1);
                }
            }
        }
        return dp[amount]  == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int pre;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if(coins[i] <= j){
                    pre = j - coins[i];
                    if(dp[pre] != Integer.MAX_VALUE){
                        dp[j] = Math.min(dp[j], dp[pre] + 1);
                    }
                }
            }
        }
        return dp[amount]  == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
