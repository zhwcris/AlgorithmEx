/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/14
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int f0 = cost[0], f1 = cost[1], f2 = 0;
//        if(cost.length == 2){
//            f2 = Math.min(f0, f1);
//        }else {
//            f2 = Math.min(f0 + cost[2], f1 + cost[2]);
//            for (int i = 3; i < cost.length; i++) {
//                f0 = f1;
//                f1 = f2;
//                f2 = Math.min(f0 + cost[i], f1 + cost[i]);
//            }
//        }
        for (int i = 2; i < cost.length; i++) {
            if(i == 2){
                f2 = Math.min(f0 + cost[i], f1 + cost[i]);
                continue;
            }
            f0 = f1;
            f1 = f2;
            f2 = Math.min(f0 + cost[i], f1 + cost[i]);
        }
        return Math.min(f1, f2);
    }
}
