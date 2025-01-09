class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        if (num / 1000 > 0) {
            for (int i = 0; i < num / 1000; i++) {
                sb.append("M");
            }
            num %= 1000;
        }
        num = transfer(num, 500, 100, "D", "C", "M", sb);
        num = transfer(num, 50, 10, "L", "X", "C", sb);
        num = transfer(num, 5, 1, "V", "I", "X", sb);

        return sb.toString();
    }

    public int transfer(int num, int five, int one, String fiveC, String oneC, String tenC, StringBuilder sb) {
        if (num / one > 0) {
            if (num / one == 9) {
                sb.append(oneC).append(tenC);
                num %= one;
            } else if (num / one == 4) {
                sb.append(oneC).append(fiveC);
                num %= one;
            } else {
                if (num / five > 0) {
                    sb.append(fiveC);
                    num %= five;
                }
                if (num / one > 0) {
                    for (int i = 0; i < num / one; i++) {
                        sb.append(oneC);
                    }
                    num %= one;
                }
            }
        }

        return num;
    }
}