import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    private List<String> dfs(){
        return null;
    }
    private boolean dfs(String s, List<String> wordDict, int index, List<String> res, boolean[] mem, String sequence){//dfs with return bool : if can be breakable
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

    private boolean dfs2(String s, List<String> wordDict, int index, List<String> res, boolean[] mem, String sequence){//dfs2 with return bool
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
}
