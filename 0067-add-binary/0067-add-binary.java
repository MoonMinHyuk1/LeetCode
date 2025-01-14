class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int art = a.length() - 1, brt = b.length() - 1;

        int p = 0;
        while (art >= 0 && brt >= 0) {
            int anum = Integer.valueOf(a.charAt(art) - '0');
            int bnum = Integer.valueOf(b.charAt(brt) - '0');
            if (p + anum + bnum > 1) {
                sb.append((p + anum + bnum) - 2);
                p = 1;
            } else {
                sb.append(p + anum + bnum);
                p = 0;
            }
            art--;
            brt--;
        }
        while (art >= 0) {
            int anum = Integer.valueOf(a.charAt(art) - '0');
            if (p + anum > 1) {
                sb.append((p + anum) - 2);
                p = 1;
            } else {
                sb.append(p + anum);
                p = 0;
            }
            art--;
        }
        while (brt >= 0) {
            int bnum = Integer.valueOf(b.charAt(brt) - '0');
            if (p + bnum > 1) {
                sb.append((p + bnum) - 2);
                p = 1;
            } else {
                sb.append(p + bnum);
                p = 0;
            }
            brt--;
        }
        if (p == 1) {
            sb.append(p);
        }
        
        return sb.reverse().toString();
    }
}