import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        return 0;
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        Iterator<List<Integer>> iterator = special.iterator();
        while (iterator.hasNext()){
            List<Integer> list = iterator.next();
            int max = getMaxNumOffer(list, needs);
            if(max != 0){
                List<Integer> copy = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++) {
                    copy.set(i, (needs.get(i) - list.get(i) * max));
                }
                dfs(price, special, copy);
            }
            iterator.remove();
        }
        return 0;
    }

    private int getMaxNumOffer(List<Integer> special, List<Integer> needs){
        int max = Integer.MAX_VALUE;
        if(special.size() == 0)return 0;
        for (int i = 0; i < needs.size(); i++) {
            if(special.get(i) == 0)continue;
            max = Math.min(max, needs.get(i)/special.get(i));
        }
        if(max == Integer.MAX_VALUE)return 0;
        return max;
    }
}
