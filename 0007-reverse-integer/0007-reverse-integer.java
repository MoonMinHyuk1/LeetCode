class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        try {
            boolean negative = false;
            if (x < 0) {
                negative = true;
                x *= -1;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            int answer = Integer.parseInt(sb.reverse().toString());
            if (negative) {
                answer *= -1;
            }

            return answer;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}