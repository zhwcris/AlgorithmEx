/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/10
 */
public class MaxSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {//利用滑动窗口的最佳例子
        //最优的一个，两个，三个数组的开始位置
        int index1 = 0;
        int[] index2 = {0, k};
        int[] index3 = {0, k, 2*k};

        int seqSum1 = 0;
        for (int i = 0; i < k; i++) {
            seqSum1 += nums[i];
        }

        int seqSum2 = 0;
        for (int i = k; i < 2 * k; i++) {
            seqSum2 += nums[i];
        }

        int seqSum3 = 0;
        for (int i = 2 * k; i < 3 * k; i++) {
            seqSum3 += nums[i];
        }


        int maxSum1 = seqSum1;
        int maxSum2 = seqSum1 + seqSum2;
        int maxSum3 = seqSum1 + seqSum2 + seqSum3;

        //窗口起始位置
        int nowIndex1 = index1 + 1;
        int nowIndex2 = index2[1] + 1;
        int nowIndex3 = index3[2] + 1;

        while (nowIndex3 <= nums.length - k){
            seqSum1 = seqSum1 - nums[nowIndex1-1] + nums[nowIndex1 + k - 1];
            seqSum2 = seqSum2 - nums[nowIndex2-1] + nums[nowIndex2 + k - 1];
            seqSum3 = seqSum3 - nums[nowIndex3-1] + nums[nowIndex3 + k - 1];

            if(seqSum1 > maxSum1){
                index1 = nowIndex1;
                maxSum1 = seqSum1;
            }
            if(seqSum2 + maxSum1 > maxSum2){
                index2[0] = index1;
                index2[1] = nowIndex2;
                maxSum2 = maxSum1 + seqSum2;
            }
            if(seqSum3 + maxSum2 > maxSum3){
                index3[0] = index2[0];
                index3[1] = index2[1];
                index3[2] = nowIndex3;
                maxSum3 = maxSum2 + seqSum3;
            }
            nowIndex1 += 1;
            nowIndex2 += 1;
            nowIndex3 += 1;
        }
        return index3;
    }

    public int[] maxSumOfThreeSubarrays1(int[] nums, int k) {// dp solution 1
        int n = nums.length;
        int m = 3;
        int[] sums = new int[n+1];
        int[][] max = new int[n+1][m+1];
        int[][] indices = new int[n+1][m+1];
        for (int i = 1; i <= n; i++)
            sums[i] = sums[i-1]+nums[i-1];
        for (int i = 1; i <= m; i++) {
            for (int j = i*k; j <= n; j++) {
                if (max[j-k][i-1]+sums[j]-sums[j-k] > max[j-1][i]) {
                    indices[j][i] = j-k;
                    max[j][i] = max[j-k][i-1]+sums[j]-sums[j-k];
                } else {
                    max[j][i] = max[j-1][i];
                    indices[j][i] = indices[j-1][i];
                }
            }
        }
        int[] ret = new int[m];
        ret[m-1] = indices[n][m];
        for (int i = m-2; i >= 0; i--)
            ret[i] = indices[ret[i+1]][i+1];
        return ret;
    }

    public int[] maxSumOfThreeSubarrays2(int[] nums, int k) {//// dp solution 2
        int[][] dp = new int[4][nums.length + 1];
        int initSum = 0;
        for(int i = 0; i < k; i++) initSum += nums[i];
        dp[1][k] = initSum;
        for(int i = 1; i < 4; i++) {
            int currSum = initSum;
            for(int j = k + 1; j < dp[0].length; j++) {
                currSum = currSum - nums[j - k - 1] + nums[j - 1];
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - k] + currSum);
            }
        }
        int[] result = new int[3];
        int curr = 2, i = 3, j = dp[0].length - 1;
        while(j >= k) {
            if(dp[i][j] > dp[i][j - 1]) {
                result[curr] = j - k;
                curr--;
                i--;
                j -= k;
            } else j--;
        }
        return result;
    }
}
