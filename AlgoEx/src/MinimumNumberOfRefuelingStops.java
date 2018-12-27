/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/27
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(stations.length == 0)return 1;
        int n = stations.length;
        int[] f = new int[n+2];
        int[] dp = new int[n+2];
        f[0] = startFuel;
        dp[0] = 0;
        for (int i = 1; i <= n+1; i++) {
            f[i] = -1;
            for (int j = 0; j < i; j++) {
                if(f[j] == -1)continue;
                if(f[j] >= stations[i][0] - stations[j][0]){

                }else {
                    
                }
            }
        }
    }
}
