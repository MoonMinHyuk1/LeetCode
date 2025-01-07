class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + len; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    len = j - i + 1;
                    start = i;
                    end = j;
                }
                if (j + 1 < s.length() && isPalindrome(s, i, j + 1)) {
                    len = j - i + 2;
                    start = i;
                    end = j + 1;
                }
            }
        }
        
        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}