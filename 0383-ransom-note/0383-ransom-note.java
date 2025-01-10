class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> r = new HashMap<>();
        Map<Character, Integer> m = new HashMap<>();

        for (char c: ransomNote.toCharArray()) {
            r.put(c, r.getOrDefault(c, 0) + 1);
        }
        for (char c: magazine.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (char key: r.keySet()) {
            int value = r.get(key);
            if (m.containsKey(key)) {
                if (m.get(key) < value) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}