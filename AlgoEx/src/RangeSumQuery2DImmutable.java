/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/12
 */
public class RangeSumQuery2DImmutable {
    int[][] accSumPerLine;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] nums = matrix[i];
            for (int j = 1; j < n; j++) {
                nums[j] += nums[j-1];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                matrix[i][j] += matrix[i-1][j];
            }
        }
        accSumPerLine = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(accSumPerLine == null)return 0;
        int sum, up = 0, left = 0, upLeft = 0;
        if(row1 - 1 >= 0 && col1 - 1 >= 0){
            upLeft = accSumPerLine[row1-1][col1-1];
        }
        if(row1 - 1 >= 0){
            up = accSumPerLine[row1-1][col2];
        }
        if(col1 - 1 >= 0){
            left = accSumPerLine[row2][col1-1];
        }
        sum = accSumPerLine[row2][col2] - up - left + upLeft;
        return sum;
    }

    //method 1 optimized before
//    int[][] accSumPerLine;
//    public NumMatrix(int[][] matrix) {
//        if(matrix == null || matrix.length == 0)return;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            int[] nums = matrix[i];
//            for (int j = 1; j < n; j++) {
//                nums[j] += nums[j-1];
//            }
//        }
//        accSumPerLine = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if(accSumPerLine == null)return 0;
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            int[] nums = accSumPerLine[i];
//            sum += col1 == 0 ? nums[col2] : nums[col2] - nums[col1-1];
//        }
//        return sum;
//    }
}
