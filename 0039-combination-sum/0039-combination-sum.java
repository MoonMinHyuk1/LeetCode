class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        combination(answer, new ArrayList<>(), 0, 0, candidates, target);

        return answer;
    }

    private void combination(List<List<Integer>> answer, List<Integer> list, int sum, int s, int[] candidates, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            list.add(candidates[i]);
            combination(answer, list, sum + candidates[i], i, candidates, target);
            list.remove(list.size() - 1);
        }
    }
}