class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] board = new int[n][m];
        int[] dx = {0, -1};
        int[] dy = {-1, 0};

        board[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) continue;
                int sum = 0;
                for (int k = 0; k < 2; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        sum += board[ni][nj];
                    }
                }
                board[i][j] = sum;
            }
        }

        return board[n - 1][m - 1];
    }
}