import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/26
 */
public class NumOfMatcSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int n = S.length(), count = 0;
        Map<Character, List<Integer[]>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new ArrayList<>());
        }
        for (int i = 0; i < words.length; i++) {
            map.get(words[i].charAt(0)).add(new Integer[]{i, 1});
        }
        for (int i = 0; i < n; i++) {
            List<Integer[]> list = new ArrayList<>(map.get(S.charAt(i)));
            map.get(S.charAt(i)).clear();
            for(Integer[] a : list){
                if(a[1] < words[a[0]].length()){
                    map.get(words[a[0]].charAt(a[1])).add(a);
                    a[1]++;
                }else {
                    count++;
                }
            }
        }
        return count;
    }

    /*-----------------------------------solution1-*/
    public int numMatchingSubseq1(String S, String[] words) {
        int n = S.length(), count = 0;
        int[] nowSearchIndex = new int[words.length];
        Arrays.fill(nowSearchIndex, -1);
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else {
                map.put(c, new ArrayList<>(Arrays.asList(i)));
            }
        }
        for (int i = 0; i < words.length; i++){
            int len = words[i].length();
            boolean find = true;
            for (int j = 0; j < len; j++){
                char c = words[i].charAt(j);
                if(!isFind(map, c, nowSearchIndex, i)){
                    find = false;
                    break;
                }
            }
            if(find)count++;
        }
        return count;
    }

    private boolean isFind(Map<Character, List<Integer>> map, char c, int[] nowSearchIndex, int i){
        List<Integer> list = map.get(c);
        if(list == null){
            return false;
        }
        for(Integer loc : list){
            if(loc > nowSearchIndex[i]){
                nowSearchIndex[i] = loc;
                return true;
            }
        }
        return false;
    }

    private int findFirstLarger(List<Integer> list, int key) {
        int left = 0;
        int right = list.size() - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
