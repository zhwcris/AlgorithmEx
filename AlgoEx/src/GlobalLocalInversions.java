import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/24
 */
public class GlobalLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int max = 0, n = A.length;
        for (int i = 0; i < n - 2; i++) {
            max = Math.max(max, A[i]);
            if(max > A[i+2])return false;
        }
        return true;
    }

    public boolean isIdealPermutation1(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if(Math.abs(A[i] - i) > 1)return false;
        }
        return true;
    }
}
