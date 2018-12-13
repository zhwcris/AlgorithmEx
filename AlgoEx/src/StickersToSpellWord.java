import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/11
 */
public class StickersToSpellWord {

    public int minStickers(String[] stickers, String target) {//第二版的bfs 利用当前的now节点的第一个字符（转化为check），来最大程度的确定遍历顺序
        //加入 A B C三个sticker是最终结果的话，则 BCA CBA ACB的结果都是一样的，这就出现了重复计算，即如果一个target可以被一组sticker拼出来，则至少有其中一个便签是包含target[0]的，比如C包含
        //target[0],则遍历顺序确定为先C,下一轮如果A包含了第一个字符则先遍历A，否则为B，(如果都包含则为 CAB 和 CBA)   最终遍历顺序为CAB
        int[] initial = new int[26];
        for (int i = 0; i < target.length(); i++) {
            initial[target.charAt(i)-'a']++;
        }
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        arrayDeque.offer(initial);
        int depth = 0;
        while (!arrayDeque.isEmpty()){
            int size = arrayDeque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] now = arrayDeque.poll();
                String check = transferHash(now);
                for (String sticker : stickers){
                    if(!sticker.contains(check.charAt(0)+""))continue;
                    boolean flag = false;
                    int[] next = Arrays.copyOf(now, now.length);
                    for (int j = 0; j < sticker.length(); j++) {
                        int index = sticker.charAt(j)-'a';
                        if(next[index] > 0){
                            next[index]--;
                            flag = true;
                        }
                    }
                    if(flag){
                        String key = transferHash(next);
                        if(key.isEmpty())return depth;
                        if(!set.contains(key)){
                            set.add(key);
                            arrayDeque.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int minStickersbfs(String[] stickers, String target) {//第一版的bfs solution一层一层的把队列里的节点访问完，可以直接记录遍历的深度depth, 此种写法较好
        int[] initial = new int[26];
        for (int i = 0; i < target.length(); i++) {
            initial[target.charAt(i)-'a']++;
        }
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        arrayDeque.offer(initial);
        int depth = 0;
        while (!arrayDeque.isEmpty()){
            int size = arrayDeque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] now = arrayDeque.poll();
                for (String sticker : stickers){
                    boolean flag = false;
                    int[] next = Arrays.copyOf(now, now.length);
                    for (int j = 0; j < sticker.length(); j++) {
                        int index = sticker.charAt(j)-'a';
                        if(next[index] > 0){
                            next[index]--;
                            flag = true;
                        }
                    }
                    if(flag){
                        String key = transferHash(next);
                        if(key.isEmpty())return depth;
                        if(!set.contains(key)){
                            set.add(key);
                            arrayDeque.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int minStickers12(String[] stickers, String target) {//迭代的版本 用二进制代表target状态，值得学习
        int n = target.length(), m = 1 << n; // if target has n chars, there will be m=2^n-1 subset of characters in target
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) dp[i] = Integer.MAX_VALUE; // use index 0 - 2^n-1 as bitmaps to represent each subset of all chars in target
        dp[0] = 0; // first thing we know is : dp[empty set] requires 0 stickers,
        for (int i = 0; i < m; i++) { // for every subset i, start from 000...000
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String s : stickers) { // try use each sticker as an char provider to populate 1 of its superset, to do that:
                int sup = i;
                for (char c : s.toCharArray()) { // for each char in the sticker, try apply it on a missing char in the subset of target
                    for (int r = 0; r < n; r++) {
                        if (target.charAt(r) == c && ((sup >> r) & 1) == 0) {
                            sup |= 1 << r;
                            break;
                        }
                    }
                }
                // after you apply all possible chars in a sticker, you get an superset that take 1 extra sticker than subset
                // would take, so you can try to update the superset's minsticker number with dp[sub]+1;
                dp[sup] = Math.min(dp[sup], dp[i] + 1);
            }
        }
        return dp[m - 1] != Integer.MAX_VALUE ? dp[m - 1] : -1;
    }

    public int minStickers11(String[] stickers, String target) {//dfs version 用0 - 2^n-1记录target中字符被cover的状态，牛BBBB
        int N = target.length();
        Integer[] dp = new Integer[1<<N];

        return searchHelper(stickers,dp,target,0);
    }

    public int searchHelper(String[] stickers,Integer[] dp,String target,int state){
        if(dp[state]!=null){
            return dp[state];
        }

        int N=target.length();
        if(state==((1<<N)-1)){
            return 0;
        }

        int minCount= Integer.MAX_VALUE;
        int originalstate = state;
        for(String str:stickers){
            char[] array = str.toCharArray();

            for(char c:array){
                for(int i=0;i<target.length();i++){
                    if(c==target.charAt(i) && ((state>>(target.length()-1-i))&1)==0){
                        state |= 1<<(target.length()-1-i);
                        break;
                    }
                }
            }
            if(state!=originalstate){
                int count = searchHelper(stickers,dp,target,state);
                if(count!=-1){
                    minCount = Math.min(minCount,1+count);
                }
            }

            state = originalstate;
        }

        if(minCount!=Integer.MAX_VALUE){
            dp[state]=minCount;
            return dp[state];
        }
        dp[state]=-1;
        return -1;
    }


    public int minStickers1(String[] stickers, String target) {
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
