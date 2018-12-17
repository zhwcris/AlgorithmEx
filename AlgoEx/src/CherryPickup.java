import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/13
 */
public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = dfs(grid, dp, 0, 0, 0);
        return Math.max(res, 0);
    }

    private int dfs(int[][] grid, int[][][] dp, int x1, int y1, int x2){//dfs -1初始化数组，  -2表示该种状态state(x1, y1, x2, y2)不可到达
        int y2 = x1 + y1 - x2;
        int n = grid.length;
        if(x1 >=  n || y1 >= n || x2 >= n || y2 >= n)return -2;
        if(grid[x1][y1] == -1 || grid[x2][y2] == -1)return -2;
        if(x1 == n-1 && y1 == n-1)return grid[x1][y1];
        if(dp[x1][y1][x2] != -1)return dp[x1][y1][x2];
        int max = -2;
        max = Math.max(max, dfs(grid, dp, x1+1, y1, x2));
        max = Math.max(max, dfs(grid, dp, x1+1, y1, x2+1));
        max = Math.max(max, dfs(grid, dp, x1, y1+1, x2));
        max = Math.max(max, dfs(grid, dp, x1, y1+1, x2+1));
        if(max == -2){
            dp[x1][y1][x2] = max;
            return max;
        }
        max += grid[x1][y1] + (x1 == x2 ? 0 : grid[x2][y2]);
        dp[x1][y1][x2] = max;
        return max;
    }
    /*
    Go from (0, 0) -> (n-1, n-1) -> (0, 0) can be opt to two men go from (0, 0) -> (n-1, n-1) together, but when they go into
    the same cell, the cur state can only be added 1 (use once)
    Using DP to solve the problem:
    1.  dp[x1][y1][x2] to represent the largest ans we can get when first guy (marked as A) at(x1, y2) and second guy(marked as B) at (x2, x1 + y1 - x2)
        * because we can only go right and down, so we have x1 + y1 = x2 + y2
    2.  Induction: every time we calculate the maximum of :
        * dp[x1 - 1][y1][x2] : A down, B right
        * dp[x1][y1 - 1][x2] : A right, B right
        * dp[x1 - 1][y1][x2 - 1]: A down, B down
        * dp[x1][y1 - 1][x2 - 1]: A right, B down
        if the Max of these values is negative, then we don't have a path to this point
        else we have: dp[x1][y1][x2] = Max + grid[x1 - 1][y1 - 1] + grid[x2 - 1][y2 - 1](if x1 != x2 && y1 != y2) else we
        only add once.
    3.  Base case;
        we use dp[][][]from 1 - n, so we have:
            dp[1][1][1] = 1 and all other values are MIN_VALUE
    4.  Ans:
        dp[n][n][n]
    5.  Direction:
        from top left -> bottom right
    6.  Time:
        O(n^3)
        Space:
        O(n^3)
     */
    public int cherryPickup2(int[][] grid) {//三维数组表示更好理解一点，上面的是递归版本
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < n; y1++) {
                for (int x2 = 0; x2 < n; x2++) {
                    int y2 = x1 + y1 - x2;
                    if(y2 < 0 || y2 >= n || grid[x1][y1] == -1 || grid[x2][y2] == -1){
                        continue;
                    }
                    int max = -1;
                    if(x1 > 0)max = Math.max(max, dp[x1-1][y1][x2]);
                    if(x1 > 0 && x2 > 0)max = Math.max(max, dp[x1-1][y1][x2-1]);
                    if(y1 > 0)max = Math.max(max, dp[x1][y1-1][x2]);
                    if(y1 > 0 && x2 > 0)max = Math.max(max, dp[x1][y1-1][x2-1]);
                    if(max < 0)continue;
                    max += grid[x1][y1] + (x1 == x2 ? 0 : grid[x2][y2]);
                    dp[x1][y1][x2] = max;
                }
            }
        }
        int res = dp[n-1][n-1][n-1];
        return Math.max(res, 0);
    }
    public int cherryPickup1(int[][] grid) {
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
