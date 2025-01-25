class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'V' || c == 'L' || c == 'D' || c == 'M') {
                answer += map.get(c);
            } else if (i == s.length() - 1) {
                answer += map.get(c);
            } else {
                char nc = s.charAt(i + 1);
                if (c == 'I') {
                    if (nc == 'V' || nc == 'X') {
                        answer += map.get(nc) - map.get(c);
                        i++;
                    } else {
                        answer += map.get(c);
                    }
                }
                if (c == 'X') {
                    if (nc == 'L' || nc == 'C') {
                        answer += map.get(nc) - map.get(c);
                        i++;
                    } else {
                        answer += map.get(c);
                    }
                }
                if (c == 'C') {
                    if (nc == 'D' || nc == 'M') {
                        answer += map.get(nc) - map.get(c);
                        i++;
                    } else {
                        answer += map.get(c);
                    }
                }
            }
        }

        return answer;
    }
}