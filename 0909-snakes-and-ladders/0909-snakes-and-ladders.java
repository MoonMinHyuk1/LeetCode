class Solution {
    public int snakesAndLadders(int[][] board) {
        int answer = -1;
        int n = board.length;
        int[][] visited = new int[n][n];
        int move = Math.max(1, Math.min(6, (int) Math.pow(n, 2)));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[n - 1][0] = 0;
        pq.offer(new int[]{n - 1, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0], y = now[1], step = now[2];
            if ((n % 2 == 0 && x == 0 && y == 0) || (n % 2 == 1 && x == 0 && y == n - 1)) {
                answer = step;
                break;
            }
            for (int i = 1; i <= move; i++) {
                if ((n % 2 == 0 && x % 2 == 1) || (n % 2 == 1 && x % 2 == 0)) { //오른쪽
                    if (y == n - 1) {
                        x--;
                    } else {
                        y++;
                    }
                } else if ((n % 2 == 0 && x % 2 == 0) || (n % 2 == 1 && x % 2 == 1)) {  //왼쪽
                    if (y == 0) {
                        x--;
                    } else {
                        y--;
                    }
                }
                if (x < 0 || y < 0) continue;
                int nx = x, ny = y;
                if (board[x][y] != -1) {
                    int num = board[x][y] - 1;
                    nx = (n - 1) - (num / n);
                    if (nx % 2 == n % 2) {
                        ny = (n - 1) - (num % n);
                    } else {
                        ny = (num % n);
                    }
                }
                if (step + 1 < visited[nx][ny]) {
                    visited[nx][ny] = step + 1;
                    pq.offer(new int[]{nx, ny, step + 1});
                }
            }
        }

        return answer;
    }
}