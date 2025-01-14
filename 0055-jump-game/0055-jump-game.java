class Solution {
    boolean answer;

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        answer = false;
        boolean[] visited = new boolean[nums.length];
        
        visited[0] = true;
        dfs(0, nums, visited);

        return answer;
    }

    public void dfs(int s, int[] nums, boolean[] visited) {
        if (answer) {
            return;
        }
        int len = nums[s];
        for (int i = s + 1; i <= s + len; i++) {
            if (i >= nums.length - 1) {
                answer = true;
                return;
            }
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, nums, visited);
            }
        }
    }
}