/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/13
 */
public class StockTransaction {

    public int maxProfit(int[] prices, int fee) {
        //s0 代表第i天没有股票在手的盈利
        //s1 代表第i天有股票在手的盈利
        int s0 = 0, s1 = -50001;
        int tmp = 0;
        for (int price : prices){
            tmp = s0;
            s0 = Math.max(s0, s1 + price);
            s1 = Math.max(s1, tmp - price - fee);
        }

        return s0;
    }
}
