class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0, count = 0;

        int[] now = new int[]{0, 0};
        answer.add(matrix[0][0]);
        visited[0][0] = true;
        while (count++ < n * m - 1) {
            int i = now[0], j = now[1];
            int ni = i + dx[d], nj = j + dy[d];
            if (!(ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj])) {
                d = (d + 1) % 4;
                ni = i + dx[d];
                nj = j + dy[d];
            }
            now[0] = ni;
            now[1] = nj;
            answer.add(matrix[ni][nj]);
            visited[ni][nj] = true;
        }

        return answer;
    }
}