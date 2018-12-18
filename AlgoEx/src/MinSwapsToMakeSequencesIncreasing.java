/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/18
 */
public class MinSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        if(n == 1)return 0;
        int[] change = new int[n];
        int[] noChange = new int[n];
        change[0] = 1;
        for (int i = 1; i < n; i++) {
            if(A[i] > A[i-1] && B[i] > B[i-1]){
                if(A[i] > B[i-1] && B[i] > A[i-1]){
                    noChange[i] = Math.min(noChange[i-1], change[i-1]);
                    change[i] = Math.min(noChange[i-1], change[i-1]) + 1;
                }else {
                    noChange[i] = noChange[i-1];
                    change[i] = change[i-1] + 1;
                }
            }else {
                noChange[i] = change[i-1];
                change[i] = noChange[i-1] + 1;
            }
        }
        int res = Math.min(noChange[n-1], change[n-1]);
        return res;
    }
}
