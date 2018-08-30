import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/30
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))return true;
        int n = s1.length();
        boolean[][][] dp = new boolean[n+1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= n; j++) {
                    boolean tmp = false;
                    for (int k = 1; k < len && !tmp; k++) {
                        tmp = (dp[k][i][j] && dp[len-k][i+k][j+k] || dp[k][i][j+len-k] && dp[len-k][i+k][j]);
                    }
                    dp[len][i][j] = tmp;
                }
            }
        }
        return dp[n][0][0];
    }

    public boolean isScramble3(String s1, String s2) {
        if(s1.equals(s2))return true;
        int n = s1.length();
        boolean[][][] dp = new boolean[n+1][n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= n; j++) {
                    if(len == 1){
                        dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
                    }else {
                        boolean tmp = false;
                        for (int k = 1; k < len && !tmp; k++) {
                            tmp = (dp[k][i][j] && dp[len-k][i+k][j+k] || dp[k][i][j+len-k] && dp[len-k][i+k][j]);
                        }
                        dp[len][i][j] = tmp;
                    }
                }
            }

        }
        return dp[n][0][0];
    }

    public boolean isScramble2(String s1, String s2) {
        if(s1.equals(s2))return true;
        int len = s1.length();
        int[] count = new int[128];
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0)return false;
        }
        for (int i = 1; i < len; i++) {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }
            if(isScramble(s1.substring(0,i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0,len-i))){
                return true;
            }
        }
        return false;
    }

    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble1(String s1, String s2) {
        int len = s1.length();
        if(len == 1)return s1.equals(s2);
        if(map.containsKey(s1+s2))return map.get(s1+s2);
        if(s1.equals(s2)){
            map.put(s1+s2, true);
            return true;
        }
        for (int i = 1; i < len; i++) {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
                map.put(s1+s2, true);
                return true;
            }
            if(isScramble(s1.substring(0,i), s2.substring(len-i)) && isScramble(s1.substring(i), s2.substring(0,len-i))){
                map.put(s1+s2, true);
                return true;
            }
        }
        map.put(s1+s2, false);
        return false;
    }
}
