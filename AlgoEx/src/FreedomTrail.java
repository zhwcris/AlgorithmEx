import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/6
 */
public class FreedomTrail {

    public int findRotateSteps(String ring, String key) {//dfs + memorization
        int m = key.length(), n = ring.length();
        int[][] memo = new int[m][n];
        return dfs(ring, key, 0, 0, memo) + m;
    }

    private int dfs(String ring, String key, int i, int j, int[][] memo){
        if(i == key.length()){
            return 0;
        }
        if(memo[i][j] > 0)return memo[i][j];
        int i1 = j, i2 = j, step1 = 0, step2 = 0, n = ring.length();
        while (ring.charAt(i1) != key.charAt(i)) {//anticlockwise
            i1 = (i1 + 1) % n;
            step1++;
        }
        while (ring.charAt(i2) != key.charAt(i)) {//clockwise
            i2 = (n + i2 - 1) % n;
            step2++;
        }
        int anticlockwise = step1 + dfs(ring, key, i+1, i1, memo);
        int clockWise = step2 + dfs(ring, key, i+1, i2, memo);
        int res = Math.min(anticlockwise, clockWise);
        memo[i][j] = res;
        return res;
    }

    public int findRotateSteps1(String ring, String key) {//dp solution top-down
        int n = ring.length(), m = key.length();
        ArrayList<Integer>[] pos = new ArrayList[26];
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        for (int i = 0; i < n; i++) {
            if(pos[ring.charAt(i)-'a'] == null)pos[ring.charAt(i)-'a'] = new ArrayList<>();
            pos[ring.charAt(i)-'a'].add(i);
        }
        int[][] dp = new int[m+1][n];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 1; i <= m; i++) {
            char now = key.charAt(i-1);
            for(Integer index : tmp){
                for (Integer j : pos[now-'a']){
                    int diff = Math.abs(index - j);
                    int minDis = Math.min(diff, n - diff) + dp[i-1][index];
                    dp[i][j] = Math.min(minDis, dp[i][j]);
                    if(i == m)res = Math.min(res, dp[i][j]);
                }
            }
            tmp = pos[now-'a'];
        }
        return res + m;
    }


//    public int findRotateSteps(String ring, String key) {
//        int n = ring.length(), m = key.length();
//        int i1 = 0, i2 = 0, step1 = 0, step2 = 0, index, step = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0);
//        for (int i = 0; i < m; i++) {
//            for (Integer start : list){
//                while (ring.charAt(i1) != key.charAt(start)){
//                    i1 = (i1 + 1) % n;
//                    step1++;
//                }
//                while (ring.charAt(i2) != key.charAt(start)){
//                    i2 = (n + i2 - 1) % n;
//                    step2++;
//                }
//                step1 = step2 = 0;
//                i1 = i2 = start;
//                step
//            }
//            if(step1 > step2){
//                index = i2;
//                step += step2;
//            }else {
//                index = i1;
//                step += step1;
//            }
//            step1 = step2 = 0;
//            i1 = i2 = index;
//        }
//        return step;
//    }
}
