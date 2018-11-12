import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/9
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> map = new HashMap<>();
        for (String word : wordDict){
            char c = word.charAt(0);
            if(!map.containsKey(word.charAt(0))){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(word);
        }
        return false;
    }

    private boolean dfs(String s, Map<Character, List<String>> map, int index){
        return false;
    }
}
