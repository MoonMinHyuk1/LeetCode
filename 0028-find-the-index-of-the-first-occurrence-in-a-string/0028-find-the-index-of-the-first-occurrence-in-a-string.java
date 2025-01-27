class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            int index = 0;
            while (index < needle.length()) {
                if (needle.charAt(index) != haystack.charAt(i + index)) {
                    flag = false;
                    break;
                }
                index++;
            }
            if (flag) {
                return i;
            }
        }
        
        return -1;
    }
}