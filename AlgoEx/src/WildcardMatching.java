/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/19
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {//trick solution
        int i=0, j=0, star=-1, si=0, n = s.length(), m = p.length();
        while(i < n) {
            if(j < m && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (j < m && p.charAt(j) =='*') {
                star = j++;
                si = i;
            } else if (star >=0 ) {
                i = ++si;
                j = star+1;
            } else return false;
        }
        while(j < m){
            if(p.charAt(j++) != '*') return false;
        }
        return true;
    }


    public boolean isMatch3(String s, String p) {//dp solution
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || (i > 0 && dp[i-1][j]);
                }else {
                    dp[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch1(String s, String p) {
        return helper(s.toCharArray(), p.toCharArray(), 0, 0, 0, -1);
    }

    private boolean helper(char[] s, char[] p, int i, int j, int lastS, int lastP) {
        if(i == s.length && j == p.length) return true;
        if(j < p.length) {
            if(i == s.length)
                return p[j] == '*' ? helper(s, p, i, j + 1, lastS, lastP) : false;
            if(p[j] == '?' || s[i] == p[j])
                return helper(s, p, i + 1, j + 1, lastS, lastP);
            if(p[j] == '*')
                return helper(s, p, i, j + 1, i, j);
        }
        if(lastP != -1) return helper(s, p, lastS + 1, lastP, lastS + 1, lastP);
        return false;
    }

    /*
    以下方法的重点是记录最近的一个*匹配的结果，如果最后一个*没有匹配成功，就不用backTrack到前一个*继续递归搜索了，这样会造成重复的搜索
    eg s: aaabdb
       p: a*b*c   当第一个*匹配了s[1-2]两个a，之后b和b匹配，然后进入第二个*匹配，此时s会匹配剩下的d和b，结果为false,此时应该终止backtrack到上一个
                  *搜索的位置，因为b、d、b三个字符已经检查过了
                  *
    https://leetcode.com/problems/wildcard-matching/discuss/149826/Why-you-don't-need-to-backtrack-to-an-earlier-asterisk-if-you-find-a-later-asterisk.
    https://leetcode.com/problems/wildcard-matching/discuss/17859/Evolve-from-brute-force-to-optimal
    https://leetcode.com/problems/wildcard-matching/discuss/17811/My-three-C%2B%2B-solutions-(iterative-(16ms)-and-DP-(180ms)-and-modified-recursion-(88ms))
    这三个是对这种算法的解释，不错，值得一看
     */
    public boolean isMatch2(String s, String p) {
        boolean res = dfs(s, 0, p, 0, new boolean[1]);
        return res;
    }

    private boolean dfs(String s, int si, String p, int pi, boolean[]star){//继续一个练习....经过数小时的挣扎终于ac了。这是最快的dfs方法，不用cache，star是用来记录最后一个*是否匹配过
        while (si < s.length() && pi < p.length()){
            if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?'){
                si++;
                pi++;
            }else {
                break;
            }
        }
        if(pi == p.length()){
            return si == s.length();
        }
        if(p.charAt(pi) == '*'){
            for (int i = si; i <= s.length(); i++) {
                if(dfs(s, i, p, pi+1, star)){
                    return true;
                }
                if(star[0]){
                    return false;
                }
            }
            star[0] = true;
        }
        return false;
    }

    private boolean dfs2(String s, int si, String p, int pi, boolean[][] check){//没有cache的递归方法会TLE,如果加入cache会AC......?????事实证明加入cache也不对，也发生了TLE
        while (si < s.length() && pi < p.length()){
            if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?'){
                si++;
                pi++;
            }else {
                break;
            }
        }
        if(pi == p.length()){
            return si == s.length();
        }
        if(si < s.length() && check[si][pi])return false;
        if(p.charAt(pi) == '*'){
            while(pi < p.length() && p.charAt(pi) == '*')pi++;
            if(pi == p.length())return true;
            for (int i = si; i < s.length(); i++) {
                if(dfs2(s, i, p, pi, check)){
                    return true;
                }
            }
        }
        if(si < s.length())check[si][pi] = true;
        return false;
    }

    private boolean dfs1(String s, int si, String p, int pi, boolean[][] check){//第一个提交AC的递归版本solution
        if(pi == p.length()){
            return (pi - 1 >= 0 && p.charAt(pi-1) == '*') || si == s.length();
        }
        if(si == s.length()){
            int i = pi;
            while (i < p.length() && p.charAt(i) == '*')i++;
            return i == p.length();
        }
        if(check[si][pi]){
            return false;
        }
        if(p.charAt(pi) == '*'){
            for (int i = si; i < s.length(); i++) {
                if(dfs1(s, i, p, pi+1, check)){
                    return true;
                }
            }
            check[si][pi] = true;
            return false;
        }else {
            boolean res = (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') && dfs2(s, si+1, p, pi+1, check);
            if(!res)check[si][pi] = true;
            return res;
        }
    }
    /**
     * bool isMatch(string s, string p) {
        return isMatch(0,0,s,p);
        }
     bool isMatch(int i, int j, string& s, string& p) {
        int sn = s.size();
        if(j==p.size()) return i==sn;
        if(p[j]=='*') return isMatch(i,j+1,s,p) || (i<sn && isMatch(i+1,j,s,p));
        if(i<sn && (p[j]=='?'|| s[i]==p[j])) return isMatch(i+1,j+1,s,p);
        return 0;
     }
     */
}
