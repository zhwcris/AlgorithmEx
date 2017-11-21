public class MaxAreaIsland {
    int row, col;
    int[][] directory = {{-1,0},{0,1},{1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if(grid == null || grid[0].length == 0)return 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max,dfsSearch(i,j,grid));
            }
        }

        return max;
    }
    public int dfsSearch(int i, int j, int[][] array){
        int sum = 0;
        if(i >= 0 && i < row && j >= 0 && j < col){
            if(array[i][j] == 1){
                array[i][j] = -1;
                for(int l = 0; l < directory.length; l++){
                    int tmpi = i + directory[l][0];
                    int tmpj = j + directory[l][1];
                    sum += dfsSearch(tmpi,tmpj, array);
                }
                sum++;
            }
        }
        return sum;
    }
}
