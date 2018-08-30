/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/16
 */
public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int num = 0;
        for(int i = 1; i < grid.length -1; i++){
            for(int j = 1; j < grid[0].length-1; j++) {
                if(grid[i][j] == 5){
                    num += isMagic(grid, i, j) ? 1 : 0;
                }
            }
        }
        return num;
    }

    private boolean isMagic(int[][] grid, int i, int j){
        String s = "" + grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1] + grid[i+1][j] + grid[i+1][j-1] + grid[i][j-1];
        return "4381672943816729".contains(s) || "9276183492761834".contains(s);
    }
}
