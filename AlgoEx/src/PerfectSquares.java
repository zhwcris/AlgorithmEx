import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/9
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int a = (int) Math.sqrt(n);
        if(a * a == n)return 1;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(n);
        int depth = 1, tmp = 0, perFloor = 1;//perFloor每层节点记录数目，   tmp//下一层节点记录数目
        while (!arrayDeque.isEmpty()){
            if(perFloor == 0){
                depth++;
                perFloor = tmp;
                tmp = 0;
            }
            perFloor--;
            int cur = arrayDeque.poll();
            for(int i = 1; i <= Math.sqrt(cur); i++){
                int sub = cur - i*i;
                if(sub == 0){
                    return depth;
                }
                arrayDeque.add(sub);
                tmp++;
            }
        }
        return depth;
    }

    public int numSquares2(int n) {

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(n);
        int depth = 1, m = 1, tmp = 0;

        while(true){
            if(m == 0){
                depth++;
                m = tmp;
                tmp = 0;
            }

            int cur = queue.remove();
            m--;

            int l = (int) Math.sqrt(cur);
            for(int i=l; i>0; i--){
                int sq = i*i;
                int delta = cur - sq;
                if(delta == 0)
                    return depth;
                queue.add(delta);
                tmp++;
            }
        }
    }

    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1, product;
            while ((product = j * j) <= i){
                min = Math.min(min, dp[i-product] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
