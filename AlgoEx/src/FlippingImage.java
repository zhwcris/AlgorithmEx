/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/1
 */
public class FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A[0].length;
        for(int[] row : A){
            for (int i = 0; i * 2 < n; i++) {
                int tmp = row[n-i-1] ^ 1;
                row[n-i-1] = row[i] ^ 1;
                row[i] = tmp;
            }
        }
        return A;
    }
}
