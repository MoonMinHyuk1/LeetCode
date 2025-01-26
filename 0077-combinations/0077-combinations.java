class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        combination(n, k, 0, 1, new int[k], answer);

        return answer;
    }

    private void combination(int n, int k, int l, int s, int[] arr, List<List<Integer>> answer) {
        if (l == k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            answer.add(list);
            return;
        }
        for (int i = s; i <= n; i++) {
            arr[l] = i;
            combination(n, k, l + 1, i + 1, arr, answer);
        }
    }
}