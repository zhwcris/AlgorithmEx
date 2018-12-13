import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/13
 */
public class CountDifferentPalindromicSubSeq {

    int div=1000000007;
    public int countPalindromicSubsequences1(String S) {//这种方法利用treeset记录字符串各个字母的位置，然后利用ceiling 和 floor函数寻找下一个递归的位置，和下面的方法相比相同，但更加简洁
        TreeSet[] characters = new TreeSet[26];
        int len = S.length();

        for (int i = 0; i < 26; i++) characters[i] = new TreeSet<Integer>();

        for (int i = 0; i < len; ++i) {
            int c = S.charAt(i) - 'a';
            characters[c].add(i);
        }
        Integer[][] dp = new Integer[len+1][len+1];
        return memo(S,characters,dp, 0, len);
    }

    public int memo(String S, TreeSet<Integer>[] characters, Integer[][] dp, int start, int end){
        if (start >= end) return 0;
        if(dp[start][end]!=null) return dp[start][end];

        long ans = 0;

        for(int i = 0; i < 26; i++) {
            Integer new_start = characters[i].ceiling(start);
            Integer new_end = characters[i].lower(end);
            if (new_start == null || new_start >= end) continue;
            ans++;
            if (new_start != new_end) ans++;
            ans+= memo(S,characters,dp,new_start+1,new_end);

        }
        dp[start][end] = (int)(ans%div);
        return dp[start][end];
    }

    public int countPalindromicSubsequences(String S) {//记忆化搜索（Search + Memoization）
        int n = S.length();
        int[][] left = new int[4][n];               //left记录当前位置最左面的a,b,c,d的位置
        int[][] right = new int[4][n];             //right记录当前位置最右面的a,b,c,d的位置，left right这种记忆方式以前见过！！！！！！！！！！！！很重要
        for (int i = 0; i < 4; i++) {
            Arrays.fill(left[i], -1);
            Arrays.fill(right[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int c = S.charAt(i) - 'a';
            for (int j = 0; j < 4; j++) {
                if(i - 1 != -1){
                    left[j][i] = left[j][i-1];
                }else {
                    left[j][i] = -1;
                }
            }
            left[c][i] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            int c = S.charAt(i) - 'a';
            for (int j = 0; j < 4; j++) {
                if(i + 1 != n){
                    right[j][i] = right[j][i+1];
                }else {
                    right[j][i] = n;
                }
            }
            right[c][i] = i;
        }
        int[][] dp = new int[n][n];
        int res = dfs(S, dp, left, right,0, n-1);
        return res;
    }

    private int dfs(String s, int[][] dp, int[][] left, int[][] right, int start, int end){//这种解法的思路是一层一层剥洋葱，分别寻找a...a  b...b c...c d...d这种回文序列，在内层
        //比如"bccb"，按照字母来剥，先剥字母b，确定最外层"b _ _ b"，这会产生两个回文子序列"b"和"bb,，这会产生两个回文子序列"b"和"bb"，然后递归进中间的部分，把中间的回文子序列个数算出来加到结果res中，
        // 然后开始剥字母c，找到最外层"cc"，
        // 此时会产生两个回文子序列"c"和"cc"，然后由于中间没有字符串了，所以递归返回0，按照这种方法就可以算出所有的回文子序列了。
        if(start > end)return 0;
        if(dp[start][end] > 0)return dp[start][end];
        long res = 0;
        for (int i = 0; i < 4; i++) {
            int newStart = right[i][start];
            int newEnd = left[i][end];
            if(newStart > newEnd)continue;
            res++;
            if(newStart != newEnd)res++;
            res += dfs(s, dp, left, right, newStart+1, newEnd-1);
        }
        dp[start][end] = (int)(res%1000000007);
        return dp[start][end];
    }
}
