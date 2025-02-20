class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    setX.add(i);
                    setY.add(j);
                }
            }
        }
        for (int i: setX) {
            Arrays.fill(matrix[i], 0);
        }
        for (int j: setY) {
            for (int i = 0; i < n; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}