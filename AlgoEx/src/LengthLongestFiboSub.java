import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/29
 */
public class LengthLongestFiboSub {

    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(A[i], i);
            for (int j = i; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        for (int j = 2; j < n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int prev = A[j] - A[i];
                if (prev >= A[i]) {
                    break;
                }
                if (!pos.containsKey(prev)) {
                    continue;
                }
                dp[i][j] = dp[pos.get(prev)][i] + 1;
            }
        }
        int result = 0;
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < n - 1; i++) {
                if (dp[i][j] > 2) {
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public int lenLongestFibSubseq3(int[] A) {
        int len = 0, n = A.length, a, b, l;
        Set<Integer> set = new HashSet<>();
        for (int i : A)set.add(i);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++){
                a = A[i];
                b = A[j];
                l = 2;
                while (set.contains(a + b)){
                    b = a + b;
                    a = b -a;
                    l++;
                }
                len = Math.max(len, l);
            }
        }
        return len > 2 ? len : 0;
    }

    public int lenLongestFibSubseq2(int[] A) {
        int len = 0, n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n][n];
        for (int j = 0; j < A.length; j++){
            map.put(A[j], j);
            for (int i = 0; i < j; i++) {
                int minus = A[j] - A[i];
                if(minus >= A[i]){
                    dp[i][j] = 2;
                }else {
                    int pre = map.getOrDefault(minus, -1);
                    if(pre >= 0){
                        dp[i][j] = dp[pre][i] + 1;
                    }else {
                        dp[i][j] = 2;
                    }
                }
                len = Math.max(len, dp[i][j]);
            }
        }
        return len > 2 ? len : 0;
    }

    public int lenLongestFibSubseq1(int[] A) {
        int len = 0, n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n][n];
        for (int j = 0; j < A.length; j++){
            map.put(A[j], j);
            for (int i = 0; i < j; i++) {
                int pre = map.getOrDefault(A[j] - A[i], -1);
                dp[i][j] = (A[j] - A[i] < A[i] && pre >= 0) ? dp[pre][i] + 1 : 2;
                len = Math.max(len, dp[i][j]);
            }
        }
        return len > 2 ? len : 0;
    }
}
