/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/27
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i&i-1] + 1;
        }
        return res;
    }

    public int[] countBits1(int num) {
        int[] res = new int[num+1];
        for (int i = 1, j = 0; i <= num; i++, j++) {
            if((i & i-1) == 0){
                j = 0;
            }
            res[i] = res[j] + 1;
        }
        return res;
    }
}
