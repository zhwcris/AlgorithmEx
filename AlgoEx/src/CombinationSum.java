import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/6/27
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, list, candidates, target, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start){
        if(target < 0){
            return;
        }else if(target == 0){
            result.add(new ArrayList<>(list));
        }else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backTrack(result, list, candidates, target-candidates[i], i);
                list.remove(list.size()-1);
            }
        }
    }
}
