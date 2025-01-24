class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int index = 0;

        for (char c: t.toCharArray()) {
            if (c == s.charAt(index)) {
                index++;
            }
            if (index == s.length()) {
                break;
            }
        }
        if (index == s.length()) {
            return true;
        }

        return false;
    }
}