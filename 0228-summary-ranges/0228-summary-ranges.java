class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int next = findInterval(nums, i);
            String interval = (i == next) ? String.valueOf(nums[i]) : (nums[i] + "->" + nums[next]);
            answer.add(interval);
            i = next;
        }

        return answer;
    }

    public int findInterval(int[] nums, int s) {
        int prev = nums[s];

        for (int i = s + 1; i < nums.length; i++) {
            if (nums[i] == prev + 1) {
                prev = nums[i];
            } else {
                return i - 1;
            }
        }

        return nums.length - 1;
    }
}