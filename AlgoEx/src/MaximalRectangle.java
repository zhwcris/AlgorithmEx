import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/6/5
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int max = 0, m = matrix.length, n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n];
        int curLeft, curRight;
        Arrays.fill(right, n);
        for (int i = 0; i < m; i++) {
            curLeft = 0;
            curRight = n;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(curLeft, left[j]);
                }else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for(int j = n - 1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(curRight, right[j]);
                }else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for(int j = 0 ; j < n; j++){
                max = Math.max(max, (right[j] - left[j])*height[j]);
            }
        }
        return max;
    }
}
