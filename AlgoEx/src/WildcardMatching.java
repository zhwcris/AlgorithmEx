/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/19
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] check = new boolean[s.length()][p.length()];
        boolean res = dfs(s, 0, p, 0, check);
        return res;
    }

    private boolean dfs(String s, int si, String p, int pi, boolean[][] check){
        if(pi == p.length()){
            return si == s.length();
        }
        if(si == s.length()){
            return pi == p.length();
        }
        if(check[si][pi]){
            return false;
        }
        if(p.charAt(pi) == '*'){
            if(dfs(s, si, p, pi+1, check)){
                return true;
            }
            for (int i = si + 1; i <= s.length(); i++) {
                if(dfs(s, i, p, pi+1, check)){
                    return true;
                }
            }
            if(si < s.length())check[si][pi] = true;
            return false;
        }else {
            boolean res = si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') && dfs(s, si+1, p, pi+1, check);
            if(!res && si < s.length())check[si][pi] = true;
            return res;
        }
    }
}
