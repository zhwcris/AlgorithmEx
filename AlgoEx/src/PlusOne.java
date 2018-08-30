/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/25
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result;
        if(digits[0] == digits[n-1] && digits[0] == 9){
            result = new int[n + 1];
            result[0] = 1;
            return result;
        }
        result = new int[digits.length];
        int extra = 1;
        for (int i = n - 1; i >= 0; i--){
            if(digits[i] + extra == 10){
                result[i] = 0;
                extra = 1;
            }else {
                result[i] = digits[i] + extra;
                extra = 0;
            }
        }
        return result;
    }
}
