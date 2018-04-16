/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/28
 */
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int preProfit = 0, curProfit, minus;

        for (int i = 1; i < prices.length; i++) {
            minus = prices[i] - prices[i-1];
            curProfit = Math.max(minus, preProfit + minus);
            max = Math.max(max, curProfit);
            preProfit = curProfit;
        }
        return max;
    }
}
