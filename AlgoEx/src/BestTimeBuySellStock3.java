/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/2
 */
public class BestTimeBuySellStock3 {
    public int maxProfit(int[] prices) {
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
