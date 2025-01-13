class Solution {
    public String simplifyPath(String path) {
        if (path.equals("")) {
            return path;
        }
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();

        String[] arr = path.split("/");
        for (String s: arr) {
            if (s.equals("") || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.offerLast(s);
            }
        }
        if (deque.isEmpty() && path.contains("/")) {
            sb.append("/");
        }
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollFirst());
        }

        return sb.toString();
    }
}