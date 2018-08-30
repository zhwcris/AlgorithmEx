import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/28
 */
public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }
        for (int i = 0; i < B.length; i++) {
            Integer key = map.higherKey(B[i]);
            if(key == null)key = map.firstKey();
            int num = map.get(key)-1;
            if(num == 0){
                map.remove(key);
            }else {
                map.put(key, num);
            }
            res[i] = key;
        }
        return res;
    }

    public int[] advantageCount1(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res = new int[A.length];
        PriorityQueue<int[]> bSort = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < B.length; i++)bSort.offer(new int[]{B[i], i});
        int low = 0, high = A.length - 1;
        while (!bSort.isEmpty()){
            int[] cur = bSort.poll();
            if(A[high] > cur[0]){
                res[cur[1]] = A[high--];
            }else {
                res[cur[1]] = A[low++];
            }
        }
        return res;
    }
}
