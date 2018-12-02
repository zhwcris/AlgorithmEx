import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        int m = pairs.length;
        if(m == 0 || pairs[0].length == 0)return 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int pre = pairs[0][1], res = 1;
        for (int i = 1; i < m; i++) {
            if(pre < pairs[i][0]){
                pre = pairs[i][1];
                res++;
            }else if(pairs[i][1] < pre){
                pre = pairs[i][1];
            }
        }
        return res;
    }
}
