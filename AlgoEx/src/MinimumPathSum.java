/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/25
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col, i, j;
        if(grid == null || row == 0){
            return 0;
        }
        col = grid[0].length;
        int[][] pathSum = new int[grid.length][grid[0].length];
        pathSum[0][0] = grid[0][0];
        for(j = 1; j < col; j++){
            pathSum[0][j] = pathSum[0][j-1] + grid[0][j];
        }
        for(j = 1; j < row; j++){
            pathSum[j][0] = pathSum[j-1][0] + grid[j][0];
        }
        for (i = 1; i < row; i++) {
            for(j = 1; j < col; j++){
                pathSum[i][j] = Math.min(pathSum[i][j-1], pathSum[i-1][j]) + grid[i][j];
            }
        }
        return pathSum[row-1][col-1];
    }
}
