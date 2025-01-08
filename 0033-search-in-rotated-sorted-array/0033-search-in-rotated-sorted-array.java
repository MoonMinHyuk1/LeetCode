class Solution {

    public int binarySearch(int[] nums, int target, int lt, int rt) {
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int answer = -1;
        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        answer = Math.max(answer, binarySearch(nums, target, 0, index));
        answer = Math.max(answer, binarySearch(nums, target, index + 1, nums.length - 1));
        
        return answer;
    }
}