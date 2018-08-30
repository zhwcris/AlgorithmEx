/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/17
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if(A == null || A.length == 0){
            return null;
        }
        int m = A.length, n = A[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = A[j][i];
            }
        }
        return res;
    }
}
