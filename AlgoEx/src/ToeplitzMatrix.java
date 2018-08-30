import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/29
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(matrix[i][j] != matrix[i+1][j+1])return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        if (matrix.length <= 1 || matrix[0].length <= 1) return true;
        Queue<Integer> q = new LinkedList<>();
        for (int i=matrix[0].length-1; i>=0; i--){ //set criteria
            q.add(matrix[0][i]);
        }
        for (int j=1; j<matrix.length; j++){
            q.poll();
            for (int k=matrix[j].length-1; k>0; k--){
                if (matrix[j][k] == q.poll()) // compare
                    q.add(matrix[j][k]);
                else
                    return false;
            }
            q.add(matrix[j][0]);
        }
        return true;
    }
}
