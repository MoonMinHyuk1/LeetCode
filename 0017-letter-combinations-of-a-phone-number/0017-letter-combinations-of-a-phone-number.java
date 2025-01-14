class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.equals("")) {
            return answer;
        }
        String[] nums = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int[] index = digits.chars()
                            .map(c -> c - '0' - 2)
                            .toArray();
        
        dfs(answer, nums, index, new char[index.length], 0);

        return answer;
    }

    public void dfs(List<String> answer, String[] nums, int[] index, char[] str, int level) {
        if (level == index.length) {
            answer.add(String.valueOf(str));
            return;
        }
        for (char c: nums[index[level]].toCharArray()) {
            str[level] = c;
            dfs(answer, nums, index, str, level + 1);
        }
    }
}