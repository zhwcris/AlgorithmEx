import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/26
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int a : A){
            sumA += a;
            set.add(a);
        }
        for (int b : B){
            sumB += b;
        }
        int diff = (sumA - sumB) / 2;
        for (int b : B){
            if(set.contains(b + diff))return new int[]{b + diff, b};
        }
        return null;
    }
}
