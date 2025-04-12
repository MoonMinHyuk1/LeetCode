// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> answer = new ArrayList<>();
//         int len = words[0].length();
//         Map<String, Integer> map = new HashMap<>();

//         for (int i = 0; i < words.length; i++) {
//             map.put(words[i], map.getOrDefault(words[i], 0) + 1);
//         }
//         for (int i = 0; i <= s.length() - len * words.length; i++) {
//             Map<String, Integer> check = new HashMap<>();
//             int cnt = 0;
//             for (int j = i; j < i + len * words.length; j += len) {
//                 String str = s.substring(j, j + len);
//                 if (map.containsKey(str)) {
//                     check.put(str, check.getOrDefault(str, 0) + 1);
//                     if (check.get(str) > map.get(str)) {
//                         break;
//                     }
//                     cnt++;
//                 } else {
//                     break;
//                 }
//             }
//             if (cnt == words.length) {
//                 answer.add(i);
//             }
//         }

//         return answer;
//     }
// }

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int len = words[0].length();
        int wordCount = words.length;
        int totalLen = len * wordCount;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            int left = i, right = i;
            Map<String, Integer> windowMap = new HashMap<>();
            int count = 0;

            while (right + len <= s.length()) {
                String word = s.substring(right, right + len);
                right += len;

                if (wordMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + len);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += len;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
