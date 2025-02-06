class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        permutation(answer, new Integer[nums.length], nums, visited, 0);
        
        return answer;
    }

    private void permutation(List<List<Integer>> answer, Integer[] arr, int[] nums, boolean[] visited, int level) {
        if (level == nums.length) {
            answer.add(List.of(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[level] = nums[i];
                permutation(answer, arr, nums, visited, level + 1);
                visited[i] = false;
            }
        }
    }
}