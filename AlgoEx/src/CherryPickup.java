import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/13
 */
public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = grid[0][0];
        int maxK = 2 * (n - 1);
        for (int k = 0; k <= maxK; k++) {
            for (int i = 0; i < n && i <= k; i++) {
                for (int i1 = 0; i1 < n && i1 <= k; i1++) {
                    int j = k - i, j1 = k - i1;
                    if(grid[i][j] == -1 || grid[i1][j1] == -1)continue;

                    int tmp = dp[i][i1];
                    if(i > 0)tmp = Math.max(tmp, dp[i-1][i1]);
                    if(j > 0)tmp = Math.max(tmp, dp[i][i1-1]);
                }
            }
        }
        return 0;
    }
}
