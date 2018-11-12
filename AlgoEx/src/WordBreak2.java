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
        String[] mem = new String[s.length()];
        dfs(s, wordDict, 0, res, "", 0, mem);
        return res;
    }

    private void dfs(String s, List<String> wordDict, int index, List<String> res, String sequence, int last, String[] mem){
        if(index == s.length()){
            res.add(sequence.substring(0, sequence.length()-1));
            mem[last] = true;
        }
        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index,i+1);
            if(wordDict.contains(tmp)){
                sequence += tmp + " ";
                dfs(s, wordDict, i + 1, res, sequence, index, mem);
                sequence = sequence.substring(0, sequence.length() - tmp.length() - 1);
            }
        }
    }
}
