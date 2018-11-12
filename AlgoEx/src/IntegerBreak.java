/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/10/9
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; 2*j <= i; j++) {
                /** Try to write i as: i = j + S where S=i-j corresponds to either one number or a sum of two or more numbers

                 Assuming that j+S corresponds to the optimal solution for dp[i], we have two cases:
                 (1) i is the sum of two numbers, i.e. S=i-j is one number, and so dp[i]=j*(i-j)
                 (2) i is the sum of at least three numbers, i.e. S=i-j is a sum of at least 2 numbers,
                 and so the product of the numbers in this sum for S is dp[i-j]
                 (=maximum product after breaking up i-j into a sum of at least two integers):
                 dp[i] = j*dp[i-j]
                 */
                dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
