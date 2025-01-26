class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int sum = 0, lt = 0, rt = 0;

        while (rt <= nums.length) {
            if (sum >= target) {
                answer = Math.min(answer, rt - lt);
                sum -= nums[lt];
                lt++;
            } else {
                if (rt == nums.length) {
                    break;
                }
                sum += nums[rt];
                rt++;
            }
        }

        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
}