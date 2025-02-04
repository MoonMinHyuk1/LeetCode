class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                sb.append(arr[i]).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}