import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/13
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if(i != start && candidates[i] == candidates[i-1])continue;
                list.add(candidates[i]);
                backTrack(result, list, candidates, target-candidates[i], i+1);
                list.remove(list.size()-1);
            }
        }
    }
}


//            boolean same = false;
//            if(result.size() != 0){
//                List<Integer> last = result.get(result.size()-1);
//                int n1 = last.size(), n2 = list.size();
//                if(n1 == n2){
//                    same = true;
//                    for (int i = n1-1; i >= 0; i--) {
//                        if(last.get(i) != list.get(i))same = false;
//                    }
//                }
//            }
//            if(!same)result.add(new ArrayList<>(list));
