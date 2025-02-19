class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int lt = 0, rt = numbers.length - 1;

        while (lt < rt) {
            int sum = numbers[lt] + numbers[rt];
            if (sum == target) {
                answer[0] = lt + 1;
                answer[1] = rt + 1;
                break;
            } else if (sum < target) {
                lt++;
            } else {
                rt--;
            }
        }

        return answer;
    }
}