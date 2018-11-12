/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/31
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public int numTrees1(int n) {
        int[] count = new int[n+1];
        return numTrees(n, count);
    }

    private int numTrees(int n, int[] count){
        if(count[n] != 0)return count[n];
        if(n <= 1)return 1;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += numTrees(i-1, count)*numTrees(n-i, count);
        }
        count[n] = total;
        return total;
    }
}
