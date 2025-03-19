class Solution {
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE, max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            answer = Math.max(answer, max);
        }

        return answer;
    }
}