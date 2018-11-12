public class BestTimeBuySellStock2 {
    public int maxProfit(int[] prices) {
        int total = 0;
        int minus = 0;
        for(int i = 0; i < prices.length - 1; i++){
            minus = prices[i+1] - prices[i];
            total += minus > 0 ? minus : 0;
        }
        return total;
    }
}
