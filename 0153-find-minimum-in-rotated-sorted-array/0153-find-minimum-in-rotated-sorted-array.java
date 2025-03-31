class Solution {
    public int findMin(int[] nums) {
        int lt = 0, rt = nums.length - 1;
        int max = nums[nums.length - 1], index = nums.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (nums[mid] > max) {
                lt = mid + 1;
                max = nums[mid];
                index = mid;
            } else {
                rt = mid - 1;
            }
        }

        return (index == nums.length - 1) ? nums[0] : nums[index + 1];
    }
}