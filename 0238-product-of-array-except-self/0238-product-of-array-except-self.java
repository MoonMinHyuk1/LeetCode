class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int mul = 1, zeroCount = 0;

        for (int num: nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                mul *= num;
            }
            if (zeroCount > 1) {
                return answer;
            }
        }
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    answer[i] = mul;
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = mul / nums[i];
            }
        }

        return answer;
    }
}