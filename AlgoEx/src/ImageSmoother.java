public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0)return null;
        int row = M.length, col = M[0].length;
        int[][] result = new int[row][col];
        int[][] direction = {{0,0},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int tmpi, tmpj, sum = 0, count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int[] dir : direction){
                    tmpi = i + dir[0];
                    tmpj = j + dir[1];
                    if(tmpi >= 0 && tmpi < row && tmpj >= 0 && tmpj < col){
                        count++;
                        sum += M[tmpi][tmpj];
                    }
                }
                result[i][j] = sum/count;
                sum = 0;
                count = 0;
            }
        }
        return result;
    }
}
