import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/17
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int[] g : grid){
            Arrays.fill(g, 1);
        }
        for (int[] mine : mines){
            grid[mine[0]][mine[1]] = 0;
        }
        int max = -1;
        int[] res = new int[N];
        int left;
        for (int i = 0; i < N; i++) {
            left = 0;
            for (int j = 0; j < N; j++){
                if(grid[i][j] != 0){
                    grid[i][j] = Math.min(++left, ++res[j]);
                }else {
                    left = 0;
                    res[j] = 0;
                }
            }
        }
        Arrays.fill(res, 0);
        int right;
        for (int i = N - 1; i >= 0; i--) {
            right = 0;
            for (int j = N - 1; j >= 0; j--){
                if(grid[i][j] != 0){
                    grid[i][j] = Math.min(grid[i][j], Math.min(++right, ++res[j]));
                }else {
                    right = 0;
                    res[j] = 0;
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
