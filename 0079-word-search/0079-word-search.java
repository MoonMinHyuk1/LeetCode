class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    boolean flag = dfs(board, word, 1, visited, i, j);
                    visited[i][j] = false;
                    if (flag) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, boolean[][] visited, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                if (board[ni][nj] == word.charAt(index) && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    boolean flag = dfs(board, word, index + 1, visited, ni, nj);
                    visited[ni][nj] = false;
                    if (flag) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}