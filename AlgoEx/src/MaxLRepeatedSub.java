/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/30
 */
public class MaxLRepeatedSub {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if(A[i] == B[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        return max;
    }

    public int findLength1(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dp[j] = a[i] == b[j] ? 1 + dp[j + 1] : 0);
        return max;
    }

    public int findLength2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0) return 0;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if(A[i] == B[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(dp[i+1][j+1], max);
                }
            }
        }
        return max;
    }
}
