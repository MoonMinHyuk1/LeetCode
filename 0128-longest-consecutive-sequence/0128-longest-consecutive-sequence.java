class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> check = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }
        for (int num: set) {
            if (check.contains(num)) continue;
            check.add(num);
            int n = num, cnt = 1;
            while (set.contains(++n)) {
                cnt++;
                check.add(n);
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}