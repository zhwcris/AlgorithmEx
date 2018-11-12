/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/2
 */
public class BestTimeBuySellStock3 {
    public int maxProfit(int[] prices) {
        // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
        // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
        // f[0, ii] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0, tmpMax;
        int[][] f = new int[3][prices.length];
        for(int k = 1; k <= 2; k++){
                tmpMax = f[k][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                f[k][i] = Math.max(f[k][i-1], tmpMax + prices[i]);
                tmpMax = Math.max(tmpMax, f[k-1][i] - prices[i]);
                maxProfit = Math.max(f[k][i], maxProfit);
            }
        }
        return maxProfit;
    }
}
