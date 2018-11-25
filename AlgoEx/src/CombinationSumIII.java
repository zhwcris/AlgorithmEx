import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans =  new ArrayList<>();
        bfsSearchResult2(ans, new ArrayList<>(), k, 1, n);
        return ans;
    }
    public void bfsSearchResult2(List<List<Integer>> ans, List <Integer> tmp, int k, int nowValue, int n){
        if(tmp.size() > k){
            return;
        }
        if(tmp.size() == k && n ==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = nowValue; i <= 9; i++) {
            if(n < i){
                return;
            }
            tmp.add(i);
            bfsSearchResult2(ans, tmp, k, i+1, n-i);
            tmp.remove((Integer) i);
        }
    }
}
