public class KnightProbabilityInChessboard {
    public double knightProbability(int N, int K, int r, int c) {
        int[][]dirs = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
        double[][][] memo = new double[K][N][N];
        return dfs(N, K, r, c, dirs, memo)/Math.pow(8, K);
    }

    private double dfs(int N, int K, int i, int j, int[][] dirs, double[][][] memo){
        if(i < 0 || j < 0 || i > N-1 || j > N-1){
            return 0;
        }
        if(K == 0){
            return 1;
        }
        if(memo[K-1][i][j] != 0){
            return memo[K-1][i][j];
        }
        double count = 0;
        for(int[] dir : dirs){
            count += dfs(N, K-1, i+dir[0], j+dir[1], dirs, memo);
        }
        memo[K-1][i][j] = count;
        return count;
    }
}
