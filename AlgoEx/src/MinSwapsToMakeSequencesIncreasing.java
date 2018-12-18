/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/18
 */
public class MinSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        if(n == 1)return 0;
        int res = 0, tmp;
        for (int i = 1; i < n; i++) {
            if(A[i] <= A[i-1] || B[i] <= B[i-1]){
               tmp = A[i];
               A[i] = B[i];
               B[i] = tmp;
               res++;
            }
        }
        return res;
    }
}
