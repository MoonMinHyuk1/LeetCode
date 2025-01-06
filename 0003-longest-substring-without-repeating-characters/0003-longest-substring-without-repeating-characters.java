class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();

        for (char c: s.toCharArray()) {
            if (set.contains(c)) {
                while (!deque.isEmpty() && deque.peekFirst() != c) {
                    char r = deque.pollFirst();
                    set.remove(r);
                }
                deque.pollFirst();
                deque.offerLast(c);
            } else {
                deque.offerLast(c);
                set.add(c);
            }
            answer = Math.max(answer, deque.size());
        }

        return answer;
    }
}