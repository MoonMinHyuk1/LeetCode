class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int j = i + 1, len = word.length();
            while (j < words.length) {
                if (len + words[j].length() + 1 > maxWidth) {
                    break;
                }
                len += (words[j].length() + 1);
                j++;
            }
            int cnt = j - i;
            if (cnt == 1) {
                while (len < maxWidth) {
                    word += " ";
                    len++;
                }
            } else {
                len = len - cnt + 1;
                int space = (maxWidth - len) / (cnt - 1);
                len = len + (space * (cnt - 1));
                for (int k = i + 1; k < j; k++) {
                    for (int l = 0; l < space; l++) {
                        word += " ";
                    }
                    if (len < maxWidth) {
                        word += " ";
                        len++;
                    }
                    word += words[k];
                }
            }
            i = j - 1;
            answer.add(word);
        }
        String word = "";
        String[] last = answer.get(answer.size() - 1).split(" ");
        answer.remove(answer.size() - 1);
        for (String str: last) {
            if (str.length() == 0) continue;
            word += str;
            if (word.length() < maxWidth) {
                word += " ";
            }
        }
        while (word.length() < maxWidth) {
            word += " ";
        }
        answer.add(word);
        
        return answer;
    }
}