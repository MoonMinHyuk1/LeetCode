class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int answer = Integer.MAX_VALUE;
        int n = triangle.size(), m = triangle.get(n - 1).size();
        int[][] dp = new int[n][m];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + num;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                }
            }
        }
        for (int num: dp[n - 1]) {
            answer = Math.min(answer, num);
        }

        return answer;
    }
}