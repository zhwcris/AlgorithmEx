import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        if(words == null || words.length == 0)return res;
        int n = words.length, minLen = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(words[i]);
            minLen = Math.min(minLen, words[i].length());
        }
        minLen *= 2;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if(word.length() < minLen)continue;
            if(dfs(word, 0, set, 0)){
                res.add(word);
            }
        }
        return res;
    }

    private boolean dfs(String s, int index, HashSet<String> set, int count){//check string s if is a concatenated word
        if(index == s.length() && count >= 2)return true;
        for (int i = index; i < s.length(); i++){
            String tmp = s.substring(index, i+1);
            if(set.contains(tmp)){
                count++;
                if(dfs(s, i+1, set, count))return true;
                count--;
            }
        }
        return false;
    }
}
