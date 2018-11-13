import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {//bfs solution
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int index, n = s.length();
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()){
            index = queue.poll();
            if(visited[index])continue;
            visited[index] = true;
            for (int i = index; i < n; i++) {
                if(wordDict.contains(s.substring(index, i+1))){
                    if(i == n-1)return true;
                    queue.offer(i+1);
                }
            }
        }
        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {//dp solution
        int n = s.length();
        boolean[] dp = new boolean[n+1];//dp[i] ----> s[0...i-1] is wordbreakable
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(dp[j] == true && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {//dfs with memorization
        boolean[] mem = new boolean[s.length()];//记录以i为开头的字符串不是word sequence
        Set<String> set = new HashSet<>(wordDict);
        return dfs(s, set, 0, mem);
    }

    private boolean dfs(String s, Set<String> wordDict, int index, boolean[] mem){
        if(index == s.length())return true;
        if(mem[index])return false;
        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index,i+1);
            if(wordDict.contains(tmp) && dfs(s, wordDict, i + 1, mem)){
                return true;
            }
        }
        mem[index] = true;
        return false;
    }
}
