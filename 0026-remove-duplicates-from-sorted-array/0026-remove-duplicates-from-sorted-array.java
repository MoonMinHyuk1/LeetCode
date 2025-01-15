class Solution {
    public int removeDuplicates(int[] nums) {
        int answer = 1;
        int index = 1, num = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != num) {
                answer++;
                nums[index] = nums[i];
                index++;
                num = nums[i];
            }
        }

        return answer;
    }
}