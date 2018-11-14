import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/14
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes){// same with LIS question
        int n = envelopes.length;
        if(n == 0)return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int len = 0;
        int[] tail = new int[n];
        for (int[] envelop : envelopes){
            int index = Arrays.binarySearch(tail, 0, len, envelop[1]);
            if(index < 0){
                index = -(index + 1);
            }
            tail[index] = envelop[1];
            if(index == len){
                len++;
            }
        }
        return len;
    }
    public int maxEnvelopes1(int[][] envelopes) {// come by myself but not familiar with Arrays.sort with int[][] and comparator
        int n = envelopes.length;
        if(n == 0)return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
