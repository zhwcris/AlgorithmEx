import java.util.Arrays;

public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] dir = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
        int[][][] memo = new int[N][m][n];
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < m; l++) {
                Arrays.fill(memo[k][l], -1);
            }
        }
        int res = dfs(m, n, N, i, j, dir, memo);
        return res;
    }

    private int dfs(int m, int n, int N, int i, int j, int[][] dir, int[][][] memo){//dfs with memorization
        if(i < 0 || j < 0 || i > m - 1 || j > n - 1){
            return 1;
        }
        if(N == 0){
            return 0;
        }
        if(memo[N-1][i][j] != -1){
            return memo[N-1][i][j];
        }
        int num = 0;
        for (int[] d : dir){
            num += dfs(m, n, N-1, i + d[0], j + d[1], dir, memo);
            num = num % 1000000007;
        }
        memo[N-1][i][j] = num;
        return memo[N-1][i][j];
    }

    private int dfs1(int m, int n, int N, int i, int j, int[][] dir){//dfs without memorization, it is no efficient enough
        if(i < 0 || j < 0 || i > m - 1 || j > n - 1){
            return 1;
        }
        if(N == 0){
            return 0;
        }
        int num = 0;
        for (int[] d : dir){
            num += dfs1(m, n, N-1, i + d[0], j + d[1], dir);
        }
        return num % 1000000007;
    }
}
