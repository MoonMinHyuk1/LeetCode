class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int lt = 0, rt = height.length - 1;

        int h = Integer.MAX_VALUE;
        while (lt <= rt) {
            h = Math.min(height[lt], height[rt]);
            answer = Math.max(answer, h * (rt - lt));
            if (height[lt] < height[rt]) {
                lt++;
            } else {
                rt--;
            }
        }

        return answer;
    }
}