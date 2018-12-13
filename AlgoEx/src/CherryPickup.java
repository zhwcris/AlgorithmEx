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
        dp[0][0] = grid[0][0];
        int maxK = 2 * (n - 1);
        for (int k = 1; k <= maxK; k++) {   //i + j = i1 + j1 = k, 没人走了k步，横纵坐标相加等于走的步数
            for (int i = n-1; i >= 0; i--) {////start from large index to small one, so do not override the needed result from n - 1;
                for (int i1 = n-1; i1 >= 0; i1--) {
                    int j = k - i, j1 = k - i1;
                    if(j < 0 || j >= n || j1 < 0 || j1 >= n || grid[i][j] < 0 || grid[i1][j1] < 0){
                        dp[i][i1] = -1;
                        continue;
                    }
                    int tmp = dp[i][i1];
                    if(i > 0)tmp = Math.max(tmp, dp[i-1][i1]);
                    if(i1 > 0)tmp = Math.max(tmp, dp[i][i1-1]);
                    if(i > 0 && i1 > 0)tmp = Math.max(tmp, dp[i-1][i1-1]);
                    if(tmp < 0)continue;

                    tmp += grid[i][j] + (i == i1 ? 0 : grid[i1][j1]);

                    dp[i][i1] = tmp;
                }
            }
        }
        return Math.max(dp[n-1][n-1], 0);
    }
}
