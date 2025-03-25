class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        
        answer[0] = findLeft(nums, target);
        answer[1] = findRight(nums, target);

        return answer;
    }

    private int findLeft(int[] nums, int target) {
        boolean check = false;
        int lt = 0, rt = nums.length - 1, index = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] == target) {
                check = true;
                index = mid;
            }
            if (nums[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return (check) ? index : -1;
    }

    private int findRight(int[] nums, int target) {
        boolean check = false;
        int lt = 0, rt = nums.length - 1, index = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] == target) {
                check = true;
                index = mid;
            }
            if (nums[mid] <= target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return (check) ? index : -1;
    }
}