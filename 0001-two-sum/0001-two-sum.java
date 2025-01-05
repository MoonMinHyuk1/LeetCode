import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                boolean flag = false;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i] && (i != j)) {
                        answer[0] = i;
                        answer[1] = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }

        return answer;
    }
}