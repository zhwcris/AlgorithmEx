import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/11
 */
public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        int[] count = new int[26];
        HashMap<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            count[target.charAt(i)-'a']++;
        }
        dp.put("", 0);
        int res = dfs(stickers, count, dp);
        return res;
    }

    private int dfs(String[] stickers, int[] count, HashMap<String, Integer> dp){//用target各个字母的数目代表当前递归的状态，从而达到cache的目的
        String key = transferHash(count);
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int res = Integer.MAX_VALUE;
        for(String sticker : stickers){
            boolean flag = false;
            int[] newCount = Arrays.copyOf(count, count.length);
            for(int i = 0; i < sticker.length(); i++){
                int idex = sticker.charAt(i)-'a';
                if(newCount[idex] > 0){
                    newCount[idex]--;
                    flag = true;
                }
            }
            if(flag){
                int tmp = dfs(stickers, newCount, dp);
                if(tmp != -1)res = Math.min(res, tmp + 1);
            }
        }
        if (res == Integer.MAX_VALUE) {
            dp.put(key, -1);
            return -1;
        }
        dp.put(key, res);
        return res;
    }

    private String transferHash(int[] count){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0)s.append((char)(i + 'a')).append(count[i]);
        }
        return s.toString();
    }

    private int dfs(String[] stickers, String target, int stickerPos, int index, int[] count) {//第一版的提交，超时了，无法正确的利用memorization， 因为此种dfs没办法记录当前的状态，是一个字母一个字母的
        //匹配，应该一次把一个单词所能匹配的字母都算进来
        if (index == target.length()) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        char c = target.charAt(index);
        if (count[c - 'a'] == 0) {
            for (int i = 0; i < stickers.length; i++) {
                String s = stickers[i];
                if (s.contains(c + "")) {
                    int[] newCount = Arrays.copyOf(count, count.length);
                    for (int j = 0; j < s.length(); j++) {
                        newCount[s.charAt(j) - 'a']++;
                    }
                    newCount[c - 'a']--;
                    int tmp = dfs(stickers, target, i, index + 1, newCount);
                    if (tmp != -1) {
                        res = Math.min(res, 1 + tmp);
                    }
                }
            }
        } else {
            count[c - 'a']--;
            int tmp = dfs(stickers, target, stickerPos, index + 1, count);
            if (tmp != -1) {
                res = Math.min(res, tmp);
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
}
