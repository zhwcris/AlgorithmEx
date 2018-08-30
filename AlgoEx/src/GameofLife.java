/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/13
 */
public class GameofLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)return;
        int m = board.length, n = board[0].length, lives;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                lives = liveNeighbours(board, i, j, m, n);
                if(board[i][j] == 0 && lives == 3)board[i][j] = 2;
                if(board[i][j] == 1 && (lives < 2 || lives > 3))board[i][j] = 3;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }else if(board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }
    }


    private int liveNeighbours(int[][] board, int i, int j, int m, int n){
        int mx = Math.min(m-1, i+1), ny = Math.min(n-1, j+1);
        int lives = 0;
        for (int x = Math.max(i-1,0); x <= mx; x++){
            for (int y = Math.max(j-1,0); y <= ny; y++){
                if(board[x][y] == 1 || board[x][y] == 3)lives++;
            }
        }
        if(board[i][j] == 1 || board[i][j] == 3)lives--;
        return lives;
    }
}
