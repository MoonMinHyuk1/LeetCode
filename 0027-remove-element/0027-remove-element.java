class Solution {
    public int removeElement(int[] nums, int val) {
        int answer = 0;
        int index = nums.length - 1;

        for (int num: nums) {
            if (num == val) {
                answer++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                while (i <= index) {
                    if (nums[index] != val) {
                        int temp = nums[i];
                        nums[i] = nums[index];
                        nums[index] = temp;
                        index--;
                        break;
                    }
                    index--;
                }
            }
        }

        return nums.length - answer;
    }
}