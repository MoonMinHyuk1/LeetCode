class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                            cnt++;
                        }
                    }
                }
                if (board[i][j] == 0) {
                    if (cnt == 3) {
                        board[i][j] = 3;
                    }
                }
                if (board[i][j] == 1) {
                    if (cnt != 2 && cnt != 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}