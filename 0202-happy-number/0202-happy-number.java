class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            int temp = 0;
            while (n > 0) {
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = temp;
        }

        return true;
    }
}