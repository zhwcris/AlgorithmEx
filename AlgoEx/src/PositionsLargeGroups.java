import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/1
 */
public class PositionsLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {//此种写法会减少i - j差值的判断次数  明显提升性能
        int i = 0, j = 0, N = S.length();
        List<List<Integer>> res = new ArrayList<>();
        while (j < N) {
            while (j < N && S.charAt(j) == S.charAt(i)) ++j;
            if (j - i >= 3) res.add(Arrays.asList(i, j - 1));
            i = j;
        }
        return res;
    }

    public List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int i, j, len = S.length();
        for (i = 0, j = 0; i < len; i++) {
            if(S.charAt(i) != S.charAt(j)){
                if(i - j > 2){
                    res.add(Arrays.asList(new Integer[]{j, i-1}));
                }
                j = i;
            }
        }
        if(i - j > 2)res.add(Arrays.asList(new Integer[]{j, i-1}));
        return res;
    }

    public List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> res = new ArrayList<>();
        char[] chars = S.toCharArray();
        int i, j;
        for (i = 0, j = 0; i < chars.length; i++) {
            if(chars[i] != chars[j]){
                if(i - j > 2){
                    res.add(Arrays.asList(new Integer[]{j, i-1}));
                }
                j = i;
            }
        }
        if(i - j > 2)res.add(Arrays.asList(new Integer[]{j, i-1}));
        return res;
    }
}
