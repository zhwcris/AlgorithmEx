/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/12
 */
public class BestTimeBuySellStockCooldown {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)return 0;
        int n = prices.length;
        int[] s0 = new int[n], s1 = new int[n], s2 = new int[n];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
            s2[i] = s1[i-1] + prices[i];
        }
        return Math.max(s0[n-1], s2[n-1]);
    }


    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length == 0)return 0;
        int n = prices.length;
        int[] buy = new int[n+1], sell = new int[n+1]; //buy[i]:the max profit of the first i days end up with buy or wait  eg:buy sell buy or
        buy[1] = -prices[0];
        for (int i = 2; i <= n; i++) {
            buy[i] = Math.max(sell[i-2] - prices[i-1], buy[i-1]);
            sell[i] = Math.max(buy[i-1] + prices[i-1], sell[i-1]);
        }
        return sell[n];
    }

    public int maxProfit3(int[] prices) {   //not committed realized by others inspired by first method
        if (prices == null || prices.length < 2) return 0;
        int buy = -prices[0], sell = Integer.MIN_VALUE, rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = buy;
            buy = Math.max(buy, rest - prices[i]);
            rest = Math.max(rest, sell);
            sell = tmp + prices[i];
        }
        return Math.max(buy, Math.max(sell, rest));
    }

//    public int maxProfit(int[] prices) {       *************not proper method but a good example for finding local min and max
//        int min, i = 0, profit = 0;
//        while (i < prices.length){
//            while (i < prices.length - 1 && prices[i] >= prices[i+1])i++;
//            min = prices[i++];
//
//            while (i < prices.length - 1 && prices[i] <= prices[i+1])i++;
//
//            profit += i < prices.length ? prices[i] - min : 0;
//            i += 2;
//        }
//        return profit;
//    }
}
