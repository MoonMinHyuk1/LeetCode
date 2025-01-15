class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    answer++;
                    visited[i][j] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int x = now[0];
                        int y = now[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[i].length && !visited[nx][ny] && grid[nx][ny] == '1') {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}