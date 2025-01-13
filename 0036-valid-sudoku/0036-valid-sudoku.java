class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!validRow(board, i)) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (!validColumn(board, j)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!validSquare(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean validSquare(char[][] board, int x, int y) {
        Set<Integer> set = new HashSet<>();

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == '.') continue;
                int n = board[i][j] - '0';
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
            }
        }

        return true;
    }

    public boolean validRow(char[][] board, int x) {
        Set<Integer> set = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            if (board[x][j] == '.') continue;
            int n = board[x][j] - '0';
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }

        return true;
    }

    public boolean validColumn(char[][] board, int y) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (board[i][y] == '.') continue;
            int n = board[i][y] - '0';
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }

        return true;
    }
}