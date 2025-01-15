class Solution {
    public int removeDuplicates(int[] nums) {
        int answer = 1;
        int index = 1, num = nums[0], cnt = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                if (cnt < 2) {
                    answer++;
                    nums[index] = nums[i];
                    index++;
                    cnt++;
                }
            } else {
                answer++;
                nums[index] = nums[i];
                index++;
                num = nums[i];
                cnt = 1;
            }
        }

        return answer;
    }
}