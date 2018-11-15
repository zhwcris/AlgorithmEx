import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/12
 */
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        boolean[] mem = new boolean[s.length()];
        dfs(s, wordDict, 0, res, mem, "");
        return res;
    }

    //dfs with list result.......................................................
    private List<String> dfs(String s, List<String> wordDict, int index, HashMap<Integer, List<String>> map){
        if(map.containsKey(index)){
            return map.get(index);
        }
        List<String> res = new ArrayList<>();
        if(index == s.length()){
            res.add("");
            return res;
        }
        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index,i+1);
            if(wordDict.contains(tmp)){
                List<String> strs = dfs(s, wordDict, i+1, map);
                for (String str : strs){
                    String tmpRes = tmp + (str.isEmpty() ? "" : " ") + str;
                    res.add(tmpRes);
                }
            }
        }
        map.put(index, res);
        return res;
    }

    //dfs with return bool : if can be breakable...........................................
    private boolean dfs(String s, List<String> wordDict, int index, List<String> res, boolean[] mem, String sequence){
        if(index == s.length()){
            res.add(sequence.substring(1));
            return true;
        }
        boolean possible = false;
        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index,i+1);
            if(wordDict.contains(tmp)){
                if(mem[index]){
                    continue;
                }
                String tmpSeq = sequence + " " + tmp;
                boolean flag = dfs(s, wordDict, i + 1, res, mem, tmpSeq);
                possible = flag || possible;
            }
        }
        mem[index] = !possible;
        return possible;
    }

    //dfs2 with return bool....................................
    private boolean dfs2(String s, List<String> wordDict, int index, List<String> res, boolean[] mem, String sequence){
        if(index == s.length()){
            res.add(sequence.substring(1));
            return true;
        }
        if(mem[index] == true)return false;
        boolean possible = false;
        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index,i+1);
            if(wordDict.contains(tmp)){
                String tmpSeq = sequence + " " + tmp;
                boolean flag = dfs(s, wordDict, i + 1, res, mem, tmpSeq);
                possible = flag || possible;
            }
        }
        mem[index] = !possible;
        return possible;
    }

    // dp and backtracking solution.......................................................................
    public List<String> wordBreak1(String s, List<String> wordDict) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        if (s.length() != 0 && (wordDict == null || wordDict.size() == 0)) {
            return result;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        int max = 0;
        for (String item : wordDict) {
            max = Math.max(max, item.length());
        }
        for (int i = 1; i <= len; i++) {
            for (int j = Math.max(i - max, 0); j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[len]) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        calculate(s, wordDict, sb, result, 0, dp);
        return result;
    }
    private void calculate(String s, List<String> wordDict, StringBuilder sb, List<String> result, int start, boolean[] dp) {
        if (start == s.length()) {
            result.add(sb.toString().trim());
            return;
        }
        if(!dp[start])return;
        int length = sb.length();
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (wordDict.contains(str)) {
                sb.append(str).append(" ");
                calculate(s, wordDict, sb, result, i, dp);
                sb.setLength(length);   //string builder set length
            }
        }
    }

    //backtracking with memorization.......................................
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        boolean[] mem = new boolean[s.length()];
        dfs(s, wordDict, new StringBuilder(), res, 0, mem);
        return res;
    }

    private void dfs(String s,List<String> wordDict, StringBuilder sb, List<String> res, int index, boolean[] mem){
        if(index == s.length()){
            res.add(sb.toString().trim());
            return;
        }
        if(mem[index])return;
        int beforeSize = res.size();
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i+1);
            int length = sb.length();
            if(wordDict.contains(str)){
                sb.append(str).append(" ");
                dfs(s, wordDict, sb, res, i+1, mem);
                sb.setLength(length);
            }
        }
        if(res.size() == beforeSize){
            mem[index] = true;
        }
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<Integer>[] starts = new List[s.length() + 1]; // valid start positions
        starts[0] = new ArrayList<Integer>();

        int maxLen = getMaxLen(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= i - maxLen && j >= 0; j--) {
                if (starts[j] == null) continue;
                String word = s.substring(j, i);
                if (wordDict.contains(word)) {
                    if (starts[i] == null) {
                        starts[i] = new ArrayList<Integer>();
                    }
                    starts[i].add(j);
                }
            }
        }

        List<String> rst = new ArrayList<>();
        if (starts[s.length()] == null) {
            return rst;
        }

        dfs(rst, "", s, starts, s.length());
        return rst;
    }


    private void dfs(List<String> rst, String path, String s, List<Integer>[] starts, int end) {
        if (end == 0) {
            rst.add(path.substring(1));
            return;
        }

        for (Integer start: starts[end]) {
            String word = s.substring(start, end);
            dfs(rst, " " + word + path, s, starts, start);
        }
    }

    private int getMaxLen(Set<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            max = Math.max(max, s.length());
        }
        return max;
    }


    //my first TLE solution.............................
    public List<String> wordBreak11(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(s, wordDict, 0, res, "");
        return res;
    }

    private void dfs(String s, List<String> wordDict, int index, List<String> res, String sequence){
        if(index == s.length()){
            res.add(sequence.substring(0, sequence.length()-1));
        }
        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index,i+1);
            if(wordDict.contains(tmp)){
                sequence += tmp + " ";
                dfs(s, wordDict, i + 1, res, sequence);
                sequence = sequence.substring(0, sequence.length() - tmp.length() - 1);
            }
        }
    }
    //my first TLE solution.............................
}
