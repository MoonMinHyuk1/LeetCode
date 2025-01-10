class Solution {
    public boolean isPalindrome(String s) {
        int lt = 0, rt = s.length() - 1;
        s = s.toLowerCase();
        while (lt < rt) {
            while (lt < s.length() && !isLetter(s.charAt(lt))) {
                lt++;
            }
            while (rt >= 0 && !isLetter(s.charAt(rt))) {
                rt--;
            }
            if (lt > rt) {
                break;
            }
            if (s.charAt(lt) != s.charAt(rt)) {
                return false;
            }
            lt++;
            rt--;
        }

        return true;
    }

    public boolean isLetter(Character c) {
        return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }
}