/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/16
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {//dp[i][j] represents nums[0...j] with i subarrays, the result min(max(i sub arrays sums))
        int n = nums.length;
        int[] accSum = new int[n+1];
        accSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            accSum[i] = accSum[i-1] + nums[i-1];
        }
        int[][] dp = new int[m+1][n];
        for (int i = 0; i < n; i++) {
            dp[1][i] = accSum[i+1];
        }
        for(int i = 2; i <= m; i++){
            for (int j = i - 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j; k >= i - 1; k--) {
                    int r = accSum[j+1] - accSum[k];
                    int tmpMin = Math.max(dp[i-1][k-1], r);
                    dp[i][j] = Math.min(tmpMin, dp[i][j]);
                }
            }
        }
        return dp[m][n-1];
    }


    public int splitArray1(int[] nums, int m) {
        int n = nums.length;
        int[] accSum = new int[n+1];
        accSum[0] = nums[0];
        for (int i = 1; i <= n; i++) {
            accSum[i] = accSum[i-1] + nums[i-1];
        }
        int[][] visited = new int[n][m+1];
        int res = dfs(nums, m, accSum, 0, visited);
        return res;
    }

    private int dfs(int[] nums, int m, int[] accuSum, int start, int[][] visited){//dfs + memorization   recursive dp solution   up - bottom
        if(m == 1){
            return accuSum[nums.length] - accuSum[start];
        }
        if(visited[start][m] != 0){
            return visited[start][m];
        }
        int min = Integer.MAX_VALUE;
        for(int i = start; i < nums.length - m + 1; i++){
            int l = accuSum[i+1] - accuSum[start];
            int tmpMin = Math.max(l, dfs(nums, m-1, accuSum, i+1, visited));
            min = Math.min(min, tmpMin);
        }
        visited[start][m] = min;
        return min;
    }
}
