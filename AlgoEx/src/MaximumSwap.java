import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/26
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int maxIndex = 0, lessIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] >= chars[maxIndex])maxIndex = i;
        }
        if(chars[0] != chars[maxIndex]){
            swap(chars, 0, maxIndex);
        }else {
            int i = 1;
            while (i < chars.length && chars[i] <= chars[i-1])i++;
            if(i != chars.length){
                lessIndex = i;
                while (i < chars.length){
                    if(chars[i] >= chars[lessIndex])lessIndex = i;
                    i++;
                }
                i = 1;
                while (i < chars.length && chars[i] >= chars[lessIndex])i++;
                swap(chars, i, lessIndex);
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }

    private void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
