class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        for (int num: set) {
            answer = num;
        }
        return answer;
    }
}