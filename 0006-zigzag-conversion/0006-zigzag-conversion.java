class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String answer = "";

        int n = (numRows * 2) - 2, mul = 2 * (numRows - 2);
        for (int i = 1; i <= s.length(); i += n) {
            answer += s.charAt(i - 1);
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = i; j <= s.length(); j += n) {
                answer += s.charAt(j - 1);
                if (j + mul - 1 < s.length()) {
                    answer += s.charAt(j + mul - 1);
                }
            }
            mul -= 2;
        }
        for (int i = numRows; i <= s.length(); i += n) {
            answer += s.charAt(i - 1);
        }

        return answer;
    }
}