/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/4
 */
public class RemoveBoxes {// similar with strange printer
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return dfs(boxes, 0, n-1, 0, dp);
    }

    //dp[i][j][k] represents the max points from box[i] to box[j] with k boxes whose values equal to box[i]
    private int dfs(int[] boxed, int i, int j, int k, int[][][] dp){
        if(i > j)return 0;
        if(dp[i][j][k] > 0)return dp[i][j][k];

        for (; i + 1 <= j && boxed[i] == boxed[i+1]; i++, k++);

        int res = dfs(boxed, i+1, j, 0, dp) + (k + 1) * (k + 1);

        for (int m = i+1; m <= j; m++){
            if(boxed[m] == boxed[i]){
                res = Math.max(res, dfs(boxed, i+1, m-1, 0, dp) + dfs(boxed, m, j, k+1, dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
