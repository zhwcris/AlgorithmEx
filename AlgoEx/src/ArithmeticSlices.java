/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/20
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3)return 0;
        int n = A.length, cur = 0, count = 1, diff = A[1] - A[0], total = 0;
        for (int i = 1; i < n; i++) {
            if(A[i] - A[i-1] == diff){
                count++;
            }else {
                cur = 0;
                count = 2;
                diff = A[i] - A[i-1];
            }
            if(count >= 3){
                cur = cur + 1;
                total += cur;
            }
        }
        return total;
    }
}
