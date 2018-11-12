import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/8
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char cur = t.charAt(i);
            if(!map.containsKey(cur)){
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(i);
        }
        int index = -1;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c))return false;
            List<Integer> list = map.get(c);
            int search = binarySearch(list, index);
            if(search == list.size())return false;
            index = list.get(search);
        }
        return true;
    }

    private int binarySearch(List<Integer> list, int t){
        int low = 0, high = list.size() - 1, mid;
        while (low <= high){
            mid = (low + high) / 2;
            if(list.get(mid) <= t){
                low = mid + 1;
            }else if(list.get(mid) > t){
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean isSubsequence1(String s, String t) {
        int i = 0, j = 0, m = s.length(), n = t.length();
        while (i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                j++;
            }
        }
        int ddd = t.indexOf('0');
        return i == m;
    }
}
