class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();

        recursive(answer, n, "", 0, 0);

        return answer;
    }

    public void recursive(List<String> answer, int n, String str, int s, int e) {
        if (n == e) {
            answer.add(str);
            return;
        }
        if (s == e) {
            recursive(answer, n, str + "(", s + 1, e);
        }
        if (s > e) {
            if (s < n) {
                recursive(answer, n, str + "(", s + 1, e);
            }
            recursive(answer, n, str + ")", s, e + 1);
        }
    }
}