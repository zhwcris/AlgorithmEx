import java.util.HashMap;

public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, res = 0;
        HashMap<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - A[j];
                if(diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE)continue;
                int d = (int)diff;
                int cur = map[i].getOrDefault(d, 0);
                int pre = map[j].getOrDefault(d, 0);
                res += pre;
                map[i].put(d, cur + pre + 1);
            }
        }
        return res;
    }
}
