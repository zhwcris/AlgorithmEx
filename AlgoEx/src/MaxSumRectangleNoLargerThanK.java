import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumRectangleNoLargerThanK {
    //https://blog.csdn.net/u010167269/article/details/51734723   解释的很好
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, res = Integer.MIN_VALUE;
        if(m== 0 || n == 0)return 0;
        int[] row = new int[m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(row, 0);
            for (int j = i; j < n; j++) {
                for (int l = 0; l < m; l++){//每一列和之前所有列相加，获得新的一列，为用kadane算法求新的连续子序列提供数组row
                    row[l] += matrix[l][j];
                }
                TreeSet<Integer> treeSet = new TreeSet();
                int cumj = 0, curMax = Integer.MIN_VALUE;
                treeSet.add(0);
                for (int l = 0; l < m; l++) {
                    cumj += row[l];
                    Integer cumi = treeSet.ceiling(cumj - k);
                    if(cumi != null){
                        curMax = Math.max(curMax, cumj - cumi);
                    }
                    treeSet.add(cumj);
                }
                res = Math.max(res, curMax);
            }
        }

        return res;
    }
}
